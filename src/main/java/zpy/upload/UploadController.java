package zpy.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

	@RequestMapping("/upload.do")
	public String upload(@RequestParam(value = "file",required = false)MultipartFile file){
		File f = new File("D:\\uploadfile", file.getOriginalFilename());
		try {
			file.transferTo(f);
		} catch (IOException e) {
			return "error";
		}
		return "success";
	}
}
