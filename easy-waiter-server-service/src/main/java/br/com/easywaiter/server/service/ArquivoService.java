package br.com.easywaiter.server.service;

import org.springframework.web.multipart.MultipartFile;

public interface ArquivoService {

	public String upload(MultipartFile[] files);

}
