package co.edu.unbosque.wsresttutorial.services;

import co.edu.unbosque.wsresttutorial.dtos.NFT;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class NFTService {

    public List<NFT> getNFTS() throws IOException {

        List<NFT> nfts;

        try (InputStream is = NFTService.class.getClassLoader().getResourceAsStream("listNFT.csv")){

            HeaderColumnNameMappingStrategy<NFT> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(NFT.class);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

                CsvToBean<NFT> csvToBean = new CsvToBeanBuilder<NFT>(br)
                        .withType(NFT.class)
                        .withMappingStrategy(strategy)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                nfts = csvToBean.parse();
            }
        }
        return nfts;
    }

    public NFT createNFT(String title, String coins, String image_url, String path) throws IOException {
        String newLine = "\n"+ title +","+ coins +","+ image_url;
        FileOutputStream os = new FileOutputStream(path +"WEB-INF/classes/" + "listNFT.csv", true);
        os.write(newLine.getBytes());
        os.close();

        return new NFT(title, coins, image_url);
    }
}
