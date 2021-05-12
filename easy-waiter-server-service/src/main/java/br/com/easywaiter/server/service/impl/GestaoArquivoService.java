package br.com.easywaiter.server.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GestaoArquivoService {

	private final Path diretorioUploads = Paths.get("/uploads").toAbsolutePath().normalize();

	@Autowired(required = true)
	public GestaoArquivoService() throws Exception {

		try {
			Files.createDirectories(this.diretorioUploads);
		} catch (Exception ex) {
			throw new Exception("Diretório não criado.", ex);
		}
	}

	public String armazenar(MultipartFile file, String name) throws Exception {
		String fileName = name != null ? name : StringUtils.cleanPath(file.getOriginalFilename());

		try {
			if (fileName.contains("..")) {
				throw new Exception("Desculpe! Nome do arquivo contém sequência de caminho inválida " + fileName);
			}

			Path targetLocation = this.diretorioUploads.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			return fileName;
		} catch (IOException ex) {
			throw new Exception("Não foi possível armazenar o arquivo " + fileName + ". Por favor, tente novamente!",
					ex);
		}
	}

	public Resource carregar(String fileName) throws Exception {
		try {
			Path filePath = this.diretorioUploads.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new Exception("Arquivo não encontrado " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new Exception("Arquivo não encontrado " + fileName, ex);
		}
	}

	public URI adquirirPath(String fileName) throws Exception {
		Path filePath = this.diretorioUploads.resolve(fileName).normalize();
		return filePath.toUri();
	}
}