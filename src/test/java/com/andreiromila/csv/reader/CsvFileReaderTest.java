package com.andreiromila.csv.reader;

import com.andreiromila.csv.dto.Supplier;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CsvFileReaderTest {

    @Test
    void readsSupplier() {
        // Pepsi S.A de C.V Twenty,Fernando Toxqui,RFC1967511620,555764-9999,bmbabcd20@yopmail.com,2,Desarrollo de sistemas,True,1
        List<Supplier> suppliers = CsvFileReader.readFile("src/test/resources/suppliers_1_ok.csv", true);
        assertThat(suppliers.size()).isEqualTo(1);
    }

    @Test
    void readsSupplier_withError() {
        // Pepsi S.A de C.V Twenty,Fernando Toxqui,RFC1967511620,555764-9999,bmbabcd20@yopmail.com,2,Desarrollo de sistemas,True,1
        List<Supplier> suppliers = CsvFileReader.readFile("src/test/resources/suppliers_1_empty_line.csv", true);
        assertThat(suppliers.size()).isEqualTo(2);
    }
}