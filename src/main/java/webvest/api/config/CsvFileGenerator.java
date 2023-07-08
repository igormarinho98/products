package webvest.api.config;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.io.IOException;
import webvest.api.model.Investment;


@Component
public class CsvFileGenerator {
public void writeInvestToCsv(List<Investment> listInvest, Writer writer) throws java.io.IOException {
try {
 
	     

CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
 
for (Investment invest : listInvest) {
printer.printRecord(invest.getId(),invest.getInvestorId(),  invest.getType(), invest.getInvestedDate(), invest.getValue(), invest.getExpectedreturn(), invest.getInterestRate(), invest.getMaturity(),invest.getStatus(), invest.isActive(),invest.getDescription());	
}

} catch (IOException e) {
	e.printStackTrace();
}
}

}
