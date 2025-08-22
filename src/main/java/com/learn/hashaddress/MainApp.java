package com.learn.hashaddress;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {
        String inputFile = "src/main/java/com/learn/hashaddress/mesp_location_address_.csv";
        String outputFile = "src/main/java/com/learn/hashaddress/mesp_location_address_with_hash.csv";

        try {
            processCSVFile(inputFile, outputFile);
            System.out.println("Successfully processed CSV file: " + outputFile);
        } catch (Exception e) {
            System.err.println("Error processing CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void processCSVFile(String inputFile, String outputFile) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFile));

        if (lines.isEmpty()) {
            throw new IllegalArgumentException("CSV file is empty");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            // Process header line
            String header = lines.get(0);
            writer.println(header + ",hashed_address");

            // Process data lines
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] columns = parseCSVLine(line);

                if (columns.length >= 7) {
                    String street = columns[0];
                    String city = columns[1];
                    String country = columns[2];
                    String zipCode = columns[3];
                    String address = columns[4];
                    String latitude = columns[5];
                    String longitude = columns[6];

                    // Build full address query similar to your StringBuilder logic
                    String fullAddress = buildAddressQuery(address, city, country, zipCode);

                    // Calculate hashed address
                    String hashedAddress = hashedAddress(fullAddress);

                    // Write the line with hashed address
                    writer.println(line + "," + hashedAddress);
                } else {
                    // If line doesn't have enough columns, write as-is with empty hash
                    writer.println(line + ",");
                }
            }
        }
    }

    private static String[] parseCSVLine(String line) {
        List<String> result = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                result.add(current.toString().trim());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }

        result.add(current.toString().trim());
        return result.toArray(new String[0]);
    }

    private static String buildAddressQuery(String address, String city, String country, String zipCode) {
        StringBuilder addressQuery = new StringBuilder();

        // Start with the main address
        if (address != null && !address.trim().isEmpty() && !address.equalsIgnoreCase("null")) {
            addressQuery.append(address.trim());
        }

        // Add city if available
        if (city != null && !city.trim().isEmpty() && !city.equalsIgnoreCase("null")) {
            if (addressQuery.length() > 0) {
                addressQuery.append(", ");
            }
            addressQuery.append(city.trim());
        }

        // Add country
        if (country != null && !country.trim().isEmpty() && !country.equalsIgnoreCase("null")) {
            if (addressQuery.length() > 0) {
                addressQuery.append(", ");
            }
            addressQuery.append(country.trim());
        }

        // Add zip code if available
        if (zipCode != null && !zipCode.trim().isEmpty() && !zipCode.equalsIgnoreCase("null")) {
            // Handle both string and numeric zip codes
            try {
                double zipNum = Double.parseDouble(zipCode);
                if (zipNum > 0 && zipNum != 999999) { // Skip invalid zip codes
                    if (addressQuery.length() > 0) {
                        addressQuery.append(", ");
                    }
                    addressQuery.append(String.format("%.0f", zipNum));
                }
            } catch (NumberFormatException e) {
                // If it's not a number, treat as string
                if (addressQuery.length() > 0) {
                    addressQuery.append(", ");
                }
                addressQuery.append(zipCode.trim());
            }
        }

        return addressQuery.toString();
    }

    public static String hashedAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            return "";
        }

        // Lowercase, trim, remove extra spaces
        String trimmedAddress = address.replaceAll("\\s+", " ").toLowerCase().trim();
        return CityHash.cityHash64Hex(trimmedAddress.getBytes(), 0, trimmedAddress.length());
    }

    public static String getByAddressOrPostalCode(String address, String zipCode, String countryCode) {
        if ((zipCode == null || zipCode.isEmpty()) && (countryCode == null || countryCode.isEmpty())) {
            zipCode = extractSGPostalCode(address);
            countryCode = "SG"; // Default to Singapore if not provided
        }

        String hashedAddress = null;
        if (address != null && !address.isEmpty()) {
            hashedAddress = hashedAddress(address);
        }

        return hashedAddress;
    }

    private static String extractSGPostalCode(String address) {
        if (address == null) return "";

        String trimmedAddress = address.trim().toLowerCase();
        // Check if address ends with "Singapore {zipCode}" pattern
        if (trimmedAddress.contains("singapore")) {
            String[] parts = trimmedAddress.split("\\s+");
            if (parts.length >= 2) {
                String lastPart = parts[parts.length - 1];
                String secondLastPart = parts[parts.length - 2];

                // Check if the pattern is "Singapore {zipCode}"
                if (secondLastPart.equals("singapore") &&
                        lastPart.matches("\\d{6}")) { // Singapore postal codes are 6 digits
                    return lastPart;
                }
            }
        }
        return "";
    }
}