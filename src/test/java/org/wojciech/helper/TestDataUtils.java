package org.wojciech.helper;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.UncheckedIOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class TestDataUtils {

    public static final String PUT_BRAND_NAME_INTO_LIST = "json/brands/put_brand_name_into_list.json";

    public static String getFileContent(final String filename) {
        try {
            return IOUtils.toString(new ClassPathResource(filename).getInputStream(), UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
