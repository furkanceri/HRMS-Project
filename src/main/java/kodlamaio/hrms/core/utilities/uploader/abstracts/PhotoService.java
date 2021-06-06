package kodlamaio.hrms.core.utilities.uploader.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PhotoService {
    DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
