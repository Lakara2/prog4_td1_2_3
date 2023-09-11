package com.employee.manage.Service;

import com.employee.manage.Model.Image;
import com.employee.manage.Model.Industry;
import com.employee.manage.Repository.IndustryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IndustryService {

	private final IndustryRepository industryRepository;
	private final ImageService imageService;

	public List<Industry> listAll() {
		return industryRepository.findAll();
	}

	public Industry getThis(long id) {
		Optional<Industry> optional = industryRepository.findById(id);
		return optional.orElse(null);
	}
	public Industry update(long id, Industry industry) {
		Optional<Industry> optional = industryRepository.findById(id);
		if (optional.isPresent()) {
			Industry existing = optional.get();
			existing.setLogo(industry.getLogo());
			existing.setName(industry.getName());
			existing.setNif(industry.getNif());
			existing.setStat(industry.getStat());
			existing.setAddress(industry.getAddress());
			existing.setPhone(industry.getPhone());
			existing.setEmail(industry.getEmail());

			return industryRepository.save(existing);
		} else {
			return null;
		}
	}

	public void delete(long id) {
		industryRepository.deleteById(id);
	}


	@Transactional
	public Industry save(Industry industry, MultipartFile image) throws IOException {
			Image imageSaved = imageService.save(image);
		industry.setId_image(imageSaved.getId());
		Industry saved = industryRepository.save(industry);
		return saved;
	}
}
