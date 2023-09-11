package com.employee.manage.Service;

import com.employee.manage.Model.IndustryAddress;
import com.employee.manage.Model.IndustryConf;
import com.employee.manage.Model.IndustryPhone;
import com.employee.manage.Repository.IndustryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
@AllArgsConstructor
public class IndustryConfService {
    private final IndustryRepository industryRepository;

    public IndustryConf getIndustryInformation() {
        return industryRepository.findAll().stream().findFirst().orElse(null);
    }

    public IndustryConf updateIndustryInformation(long id, IndustryConf industry) {
        IndustryConf existingIndustryConf = industryRepository.findById(id).orElse(null);
        if (existingIndustryConf != null) {
            existingIndustryConf.setIndustryName(industry.getIndustryName());
            existingIndustryConf.setIndustryDescription(industry.getIndustryDescription());
            existingIndustryConf.setIndustryPhone(industry.getIndustryPhone());
            existingIndustryConf.setIndustrySlogan(industry.getIndustrySlogan());
            existingIndustryConf.setIndustryLogo(industry.getIndustryLogo());
            existingIndustryConf.setNIF(industry.getNIF());
            existingIndustryConf.setSTAT(industry.getSTAT());
            existingIndustryConf.setRCS(industry.getRCS());
            existingIndustryConf.setIndustryEmail(industry.getIndustryEmail());
            existingIndustryConf.setIndustryAddress(industry.getIndustryAddress());
            return industryRepository.save(industry);
        }
        return null;
    }
    public IndustryConf getThis(long id) {
        Optional<IndustryConf> optionalIndustryConf = industryRepository.findById(id);
        return optionalIndustryConf.orElse(null);
    }

    public IndustryConf getDefaultIndustry() {
        return industryRepository.findFirstByOrderById();
    }

    public IndustryConf update(long id, IndustryConf industryConf) {
        Optional<IndustryConf> optionalIndustryConf = industryRepository.findById(id);
        if (optionalIndustryConf.isPresent()) {
            IndustryConf existingIndustryConf = optionalIndustryConf.get();
            existingIndustryConf.setIndustryName(industryConf.getIndustryName());
            existingIndustryConf.setIndustryDescription(industryConf.getIndustryDescription());
            existingIndustryConf.setIndustryPhone(industryConf.getIndustryPhone());
            existingIndustryConf.setIndustrySlogan(industryConf.getIndustrySlogan());
            existingIndustryConf.setIndustryLogo(industryConf.getIndustryLogo());
            existingIndustryConf.setNIF(industryConf.getNIF());
            existingIndustryConf.setSTAT(industryConf.getSTAT());
            existingIndustryConf.setRCS(industryConf.getRCS());
            existingIndustryConf.setIndustryEmail(industryConf.getIndustryEmail());
            existingIndustryConf.setIndustryAddress(industryConf.getIndustryAddress());
            return industryRepository.save(existingIndustryConf);
        } else {
            return null;
        }
    }
/*

    public void save(IndustryConf industry, byte[] logo, boolean isUpdate) throws FileNotFoundException {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();

        objectBuilder
                .add("industryName", industry.getIndustryName())
                .add("industryDescription", industry.getIndustryDescription())
                .add("industrySlogan", industry.getIndustrySlogan())
                .add("industryEmail", industry.getIndustryEmail())
                .add("industryAddress", this.saveAddress(industry.getIndustryAddress()))
                .add("industryPhone", this.savePhones(industry.getIndustryPhone()))
                .add("industryLogo", this.saveLogo(logo, isUpdate));

        JsonObject object = objectBuilder.build();

        OutputStream os = new FileOutputStream("industry.json");
        JsonWriter jsonWriter = Json.createWriter(os);

        Map<String, Boolean> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory factory = Json.createWriterFactory(config);
        jsonWriter = factory.createWriter(os);

        jsonWriter.writeObject(object);
        jsonWriter.close();
    }

    private JsonObjectBuilder saveAddress(IndustryAddress address) {
        JsonObjectBuilder addressObjectBuilder = Json.createObjectBuilder();
        addressObjectBuilder
                .add("name", address.getName())
                .add("street", address.getStreet())
                .add("city", address.getCity())
                .add("zipCode", address.getZipCode());
        return addressObjectBuilder;
    }

    private JsonArrayBuilder saveLogo(byte[] logo, boolean isUpdate) {
        JsonArrayBuilder logoArrayBuilder = Json.createArrayBuilder();
        if (isUpdate) {
            if (logo.length == 0) {
                logo = this.get().getIndustryLogo();
            }
        }
        for (byte b : logo) {
            logoArrayBuilder.add(b);
        }
        return logoArrayBuilder;
    }

    private JsonArrayBuilder savePhones(List<IndustryPhone> phones) {
        JsonArrayBuilder logoArrayBuilder = Json.createArrayBuilder();
        for (IndustryPhone phone : phones) {
            logoArrayBuilder.add((JsonValue) phone);
        }
        return logoArrayBuilder;
    }
    public IndustryConf get() {
        try {
            InputStream fls = new FileInputStream("industry.json");
            JsonReader jsonReader = Json.createReader(fls);
            JsonObject object = jsonReader.readObject();

            jsonReader.close();
            fls.close();

            IndustryConf industry = new IndustryConf(get().getId(), getDefaultIndustry().getIndustryName(), getDefaultIndustry().getIndustryDescription(), get().getIndustrySlogan(), get().getIndustryEmail(), get().getIndustryAddress(),get().getIndustryLogo(),get().getIndustryPhone(),get().getNIF(),get().getSTAT(),get().getRCS());
            industry.setIndustryName(object.getString("industryName"));
            industry.setIndustryDescription(object.getString("industryDescription"));
            industry.setIndustrySlogan(object.getString("industrySlogan"));
            industry.setIndustryEmail(object.getString("industryEmail"));
            industry.setIndustryAddress(this.getIndustryAddress(object.getJsonObject("industryAddress")));
            industry.setIndustryPhone(this.getIndustryPhone(object.getJsonArray("industryPhone")));
            industry.setIndustryLogo(this.getIndustryLogo(object.getJsonArray("industryLogo")));
            return industry;
        } catch (Exception e) {
            e.printStackTrace();
            return new IndustryConf(null, null, null,null,null, new IndustryAddress(), null, new ArrayList<>(), null, null, null);
        }
    }

    private byte[] getIndustryLogo(JsonArray logoByteJsonArray) {
        byte[] logoByteArray = new byte[logoByteJsonArray.size()];
        int index = 0;
        for (JsonValue value : logoByteJsonArray) {
            logoByteArray[index++] = Byte.parseByte(value.toString());
        }
        return logoByteArray;
    }

    private IndustryAddress getIndustryAddress(JsonObject addressObject) {
        return new IndustryAddress(
                addressObject.getString("name"),
                addressObject.getString("street"),
                addressObject.getString("city"),
                addressObject.getString("zipCode")
        );
    }

    private List<IndustryPhone> getIndustryPhone(JsonArray phonesListJsonArray) {
        List<IndustryPhone> phones = new ArrayList<>();
        for (JsonValue value : phonesListJsonArray) {
            phones.toString().replaceAll("\"", "");
        }
        return phones;
    }
*/

}

