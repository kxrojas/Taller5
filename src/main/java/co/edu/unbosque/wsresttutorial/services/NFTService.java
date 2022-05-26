package co.edu.unbosque.wsresttutorial.services;

import co.edu.unbosque.wsresttutorial.dtos.NFT;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class NFTService {

    private Connection conn;

    public UsersService(Connection conn) {
        this.conn = conn;
    }

    public List<NFT> listNFTS() {
        // Object for handling SQL statement
        Statement stmt = null;

        // Data structure to map results from database
        List<NFT> nfts = new ArrayList<NFT>();

        try {
            // Executing a SQL query
            System.out.println("=> Lista de piezas de arte...");
            stmt = conn.createStatement();

            String sql = "SELECT title,fcoins,image_url FROM pieceOfArt";
            ResultSet rs = stmt.executeQuery(sql);

            // Reading data from result set row by row
            while (rs.next()) {
                // Extracting row values by column name

                String title = rs.getString("title");
                String fcoins = rs.getString("fcoins");
                String image_url = rs.getString("image_url");

                // Creating a new UserApp class instance and adding it to the array list
                nfts.add(new NFT(title,fcoins,image_url));
            }

            // Closing resources
            rs.close();
            stmt.close();
        } catch (SQLException se) {
            se.printStackTrace(); // Handling errors from database
        } finally {
            // Cleaning-up environment
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return nfts;
    }
}

