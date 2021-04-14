package br.com.easywaiter.server.api;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value = "/arquivo")
public interface ArquivoController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public abstract String uploads(MultipartFile[] files);

	@GetMapping("/files/{fileName:.+}")
	public abstract void download(String fileName, HttpServletResponse response);
}
