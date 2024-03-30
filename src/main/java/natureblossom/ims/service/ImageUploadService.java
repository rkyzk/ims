package natureblossom.ims.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;


/**
 * Upload files to AWS S3 bucket.
 *
 * @author R.Yazaki
 * @version 1.0.0
 */
@Service
public interface ImageUploadService {
	public PutObjectResult upload(
			String path,
			String fileName,
			InputStream inputStrem);
	
	public S3Object download(String path, String fileName);
	
}

	