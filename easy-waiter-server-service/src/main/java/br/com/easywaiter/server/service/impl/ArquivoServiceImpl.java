package br.com.easywaiter.server.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.easywaiter.server.service.ArquivoService;

@Service
public class ArquivoServiceImpl implements ArquivoService {

	@Autowired
	private GestaoArquivoService gestaoArquivoService;

	@Override
	public String upload(MultipartFile[] files) {

		String fileName = "";

		for (MultipartFile multipartFile : files) {
			try {
				fileName = gestaoArquivoService.armazenar(multipartFile,
						adquirirNomeArquivo() + multipartFile.getOriginalFilename());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return fileName;
	}

	private String adquirirNomeArquivo() {
		DateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyyy_HH_mm_ss");
		return dateFormat.format(new Date());
	}
}
