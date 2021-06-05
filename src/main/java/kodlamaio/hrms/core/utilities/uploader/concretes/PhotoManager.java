package kodlamaio.hrms.core.utilities.uploader.concretes;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.uploader.abstracts.PhotoService;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public class PhotoManager implements PhotoService {
    @Override
    public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
        return null;
    }
}
