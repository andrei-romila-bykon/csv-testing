package com.andreiromila.csv.reader;

import com.andreiromila.csv.dto.Supplier;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CSV file reader - reads the uploaded file and returns the list of suppliers
 * found
 *
 * @author andrei.romila
 *
 */
public class CsvFileReader {

    /**
     * Returns the list of suppliers found in the file, ignores any empty lines
     *
     * @param filename
     * @param hasHeader
     * @return
     */
    public static List<Supplier> readFile(String filename, final boolean hasHeader) {
        // final UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        final File document = new File(filename); // uploadRequest.getFile("file");
        // LOGGER.info("file Size: " + uploadRequest.getSize("file"));

        try (final CSVReader csvReader = new CSVReader(new FileReader(document), ',')) {

            // Parse all lines
            return csvReader.readAll()
                    .stream()
                    .skip(hasHeader ? 1 : 0)
                    .map(Supplier::new)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }



}
