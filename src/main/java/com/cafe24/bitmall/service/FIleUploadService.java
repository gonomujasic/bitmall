package com.cafe24.bitmall.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.bitmall.repository.FIleRepository;
import com.cafe24.bitmall.vo.ImageVo;
import com.cafe24.bitmall.vo.ProductVo;

@Service
public class FIleUploadService {

	@Autowired
	FIleRepository fIleRepository;
	
	
	private static final String SAVE_PATH = "/uploads";
	private static final String PREFIX_URL = "/uploads/images/";

	public boolean restore(ProductVo productVo) {

		List<MultipartFile> fileList = productVo.getFileList();
		
		Long productNo = productVo.getNo();
		List<ImageVo> imageList = new ArrayList<>();
		boolean result = false;
		
		for (MultipartFile multipartFile : fileList) {
			ImageVo vo = new ImageVo();
			
			String url = "";

			String orginName = multipartFile.getOriginalFilename();
			String extName = orginName.substring(orginName.lastIndexOf("."), orginName.length());
			Long size = multipartFile.getSize();
			String saveFileName = genSaveFileName(extName);
			url = PREFIX_URL + saveFileName;
			
			vo.setOriginName(orginName);
			vo.setExt(extName);
			vo.setName(saveFileName);
			vo.setPath(url);
			vo.setSize(size);
			vo.setProductNo(productNo);
						
			try {
				writeFile(multipartFile, saveFileName);
				result = fIleRepository.storeFile(vo);
				
				if(result == false)
					break;
				
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
		
		return result;

	}

	private void writeFile(MultipartFile multipartFile, String saveFileName) throws IOException {
System.out.println("writing??");
		byte[] data = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(data);
		fos.flush();
		fos.close();

	}

	private synchronized String genSaveFileName(String extName) {

		String fileName = "";

		Calendar cal = Calendar.getInstance();

		fileName += cal.get(Calendar.YEAR);
		fileName += cal.get(Calendar.MONTH);
		fileName += cal.get(Calendar.DATE);
		fileName += cal.get(Calendar.HOUR);
		fileName += cal.get(Calendar.MINUTE);
		fileName += cal.get(Calendar.SECOND);
		fileName += cal.get(Calendar.MILLISECOND);
		fileName += extName;

		return fileName;
	}

}
