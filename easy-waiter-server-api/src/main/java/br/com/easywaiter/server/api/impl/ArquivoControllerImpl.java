package br.com.easywaiter.server.api.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.easywaiter.server.api.ArquivoController;
import br.com.easywaiter.server.service.ArquivoService;
import br.com.easywaiter.server.service.impl.GestaoArquivoService;

@RestController
public class ArquivoControllerImpl implements ArquivoController {

	@Lazy
	@Autowired
	private ArquivoService arquivoService;

	@Autowired
	private GestaoArquivoService gestaoArquivoService;

	@Override
	public String uploads(@RequestPart("filename") MultipartFile[] files) {

		return arquivoService.upload(files);
	}

	@Override
	public void download(@PathVariable String fileName, HttpServletResponse response) {
		try {
			InputStream in = new FileInputStream(new File(gestaoArquivoService.adquirirPath(fileName)));

			response.setContentType(MediaType.IMAGE_JPEG_VALUE);

			IOUtils.copy(in, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
