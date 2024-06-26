package natureblossom.ims.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;


/**
 * Upload files to AWS S3 bucket.
 *
 * @author R.Yazaki
 * @version 1.0.0
 */
@Service
public class ImageUploadServiceTest {
	@Autowired
	private AmazonS3 amazonS3;
	
	@Value("${aws.s3.bucket.name}")
    private String bucketName;
	
	/*
	 * Upload files to AWS S3 bucket.
	 * 
	 * @params multipart file, folder name, file name
	 * @return image url
	 */
	public String uploadImg(MultipartFile multipartFile,
			String folder, String origFileName) {
		LocalDateTime currTime = LocalDateTime.now();
		String fileName = origFileName + currTime.toString().replace(" ", "-");
		String filePath = folder + "/" + fileName;
		try {
			// convert multipart file to file.
			File file = convertMultipartFileToFile(multipartFile);
			// upload the file to specified path
			amazonS3.putObject(bucketName, filePath, file);
			file.delete();		
		} catch (Exception e){
			e.printStackTrace();
		}
		return filePath;
	}
	
	public S3Object downloadImg(String path, String fileName) {
	        return amazonS3.getObject(path, fileName);
	}
	
	/*
	 * Convert multipart file to file
	 * 
	 * @params multipart file
	 * @return File: converted file
	 */
	public File convertMultipartFileToFile(MultipartFile file) throws IOException {
		File convertedFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convertedFile);
		fos.write(file.getBytes());
		fos.close();		
		return convertedFile;
	}
}