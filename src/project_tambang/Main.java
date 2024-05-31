package project_tambang;

import asai_project_model.*;
import tambang_DAO.*;
import java.sql.SQLException;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            CoalGettingDAO coalGettingDAO = new CoalGettingDAO();
            CompanyDAO companyDAO = new CompanyDAO();
            LocationDAO locationDAO = new LocationDAO();
            MaterialDAO materialDAO = new MaterialDAO();

            while (true) {
                System.out.println("Pilih tabel: 1-CoalGetting, 2-Company, 3-Location, 4-Material, 5-Exit");
                int tableChoice = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer

                if (tableChoice == 5) {
                    break;
                }

                System.out.println("Pilihan CRUD: 1-Create, 2-Read, 3-Update, 4-Delete");
                int crudChoice = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer

                switch (tableChoice) {
                    case 1:
                        handleCoalGettingCRUD(scanner, coalGettingDAO, crudChoice);
                        break;
                    case 2:
                        handleCompanyCRUD(scanner, companyDAO, crudChoice);
                        break;
                    case 3:
                        handleLocationCRUD(scanner, locationDAO, crudChoice);
                        break;
                    case 4:
                        handleMaterialCRUD(scanner, materialDAO, crudChoice);
                        break;
                    default:
                        System.out.println("Tabel tidak valid.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void handleCoalGettingCRUD(Scanner scanner, CoalGettingDAO coalGettingDAO, int crudChoice) throws SQLException {
        switch (crudChoice) {
            case 1:
                // Create CoalGetting
                System.out.println("Masukkan ID:");
                int id = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer

                System.out.println("Masukkan tanggal (format: yyyy-mm-dd):");
                String dateInput = scanner.nextLine();
                Date date = java.sql.Date.valueOf(dateInput);

                System.out.println("Masukkan material:");
                String material = scanner.nextLine();

                System.out.println("Masukkan kuantitas:");
                double qty = scanner.nextDouble();
                scanner.nextLine();  // Clear the buffer

                System.out.println("Masukkan tipe:");
                String type = scanner.nextLine();

                System.out.println("Masukkan pit:");
                String pit = scanner.nextLine();

                CoalGetting coalGetting = new CoalGetting(id, date, material, qty, type, pit);
                coalGettingDAO.create(coalGetting);
                System.out.println("CoalGetting created.");
                break;

            case 2:
                // Read CoalGetting
                System.out.println("Masukkan ID CoalGetting yang ingin dibaca:");
                int readId = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer

                CoalGetting readCoalGetting = coalGettingDAO.read(readId);
                System.out.println(readCoalGetting);
                break;

            case 3:
                // Update CoalGetting
                System.out.println("Masukkan ID CoalGetting yang ingin diperbarui:");
                int updateId = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer

                System.out.println("Masukkan tanggal baru (format: yyyy-mm-dd):");
                String newDateInput = scanner.nextLine();
                Date newDate = java.sql.Date.valueOf(newDateInput);

                System.out.println("Masukkan material baru:");
                String newMaterial = scanner.nextLine();

                System.out.println("Masukkan kuantitas baru:");
                double newQty = scanner.nextDouble();
                scanner.nextLine();  // Clear the buffer

                System.out.println("Masukkan tipe baru:");
                String newType = scanner.nextLine();

                System.out.println("Masukkan pit baru:");
                String newPit = scanner.nextLine();

                CoalGetting updateCoalGetting = new CoalGetting(updateId, newDate, newMaterial, newQty, newType, newPit);
                coalGettingDAO.update(updateCoalGetting);
                System.out.println("CoalGetting updated.");
                break;

            case 4:
                // Delete CoalGetting
                System.out.println("Masukkan ID CoalGetting yang ingin dihapus:");
                int deleteId = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer

                coalGettingDAO.delete(deleteId);
                System.out.println("CoalGetting deleted.");
                break;

            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }

    private static void handleCompanyCRUD(Scanner scanner, CompanyDAO companyDAO, int crudChoice) throws SQLException {
        switch (crudChoice) {
            case 1:
                // Create Company
                System.out.println("Masukkan ID:");
                int id = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer

                System.out.println("Masukkan kode perusahaan:");
                String codeCompany = scanner.nextLine();

                System.out.println("Masukkan deskripsi perusahaan:");
                String descCompany = scanner.nextLine();

                System.out.println("Masukkan tanggal pembuatan (format: yyyy-mm-dd):");
                String createdAtInput = scanner.nextLine();
                Date createdAt = java.sql.Date.valueOf(createdAtInput);

                Company company = new Company(id, codeCompany, descCompany, createdAt);
                companyDAO.create(company);
                System.out.println("Company created.");
                break;

            case 2:
                // Read Company
                System.out.println("Masukkan ID Company yang ingin dibaca:");
                int readId = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer

                Company readCompany = companyDAO.read(readId);
                System.out.println(readCompany);
                break;

            case 3:
                // Update Company
                System.out.println("Masukkan ID Company yang ingin diperbarui:");
                int updateId = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer

                System.out.println("Masukkan kode perusahaan baru:");
                String newCodeCompany = scanner.nextLine();

                System.out.println("Masukkan deskripsi perusahaan baru:");
                String newDescCompany = scanner.nextLine();

                System.out.println("Masukkan tanggal pembuatan baru (format: yyyy-mm-dd):");
                String newCreatedAtInput = scanner.nextLine();
                Date newCreatedAt = java.sql.Date.valueOf(newCreatedAtInput);

                Company updateCompany = new Company(updateId, newCodeCompany, newDescCompany, newCreatedAt);
                companyDAO.update(updateCompany);
                System.out.println("Company updated.");
                break;

            case 4:
                // Delete Company
                System.out.println("Masukkan ID Company yang ingin dihapus:");
                int deleteId = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer

                companyDAO.delete(deleteId);
                System.out.println("Company deleted.");
                break;

            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }

    private static void handleLocationCRUD(Scanner scanner, LocationDAO locationDAO, int crudChoice) throws SQLException {
        switch (crudChoice) {
            case 1:
                // Create Location
                System.out.println("Masukkan kode lokasi:");
                String codeLocation = scanner.nextLine();

                System.out.println("Masukkan deskripsi lokasi:");
                String descLocation = scanner.nextLine();

                System.out.println("Masukkan tanggal pembuatan (format: yyyy-mm-dd):");
                String createdAtInput = scanner.nextLine();
                Date createdAt = java.sql.Date.valueOf(createdAtInput);

                Location location = new Location(codeLocation, descLocation, createdAt);
                locationDAO.create(location);
                System.out.println("Location created.");
                break;

            case 2:
                // Read Location
                System.out.println("Masukkan kode lokasi yang ingin dibaca:");
                String readCodeLocation = scanner.nextLine();

                Location readLocation = locationDAO.read(readCodeLocation);
                System.out.println(readLocation);
                break;

            case 3:
                // Update Location
                System.out.println("Masukkan kode lokasi yang ingin diperbarui:");
                String updateCodeLocation = scanner.nextLine();

                System.out.println("Masukkan deskripsi lokasi baru:");
                String newDescLocation = scanner.nextLine();

                System.out.println("Masukkan tanggal pembuatan baru (format: yyyy-mm-dd):");
                String newCreatedAtInput = scanner.nextLine();
                Date newCreatedAt = java.sql.Date.valueOf(newCreatedAtInput);

                Location updateLocation = new Location(updateCodeLocation, newDescLocation, newCreatedAt);
                locationDAO.update(updateLocation);
                System.out.println("Location updated.");
                break;

            case 4:
                // Delete Location
                System.out.println("Masukkan kode lokasi yang ingin dihapus:");
                String deleteCodeLocation = scanner.nextLine();

                locationDAO.delete(deleteCodeLocation);
                System.out.println("Location deleted.");
                break;

            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }

    private static void handleMaterialCRUD(Scanner scanner, MaterialDAO materialDAO, int crudChoice) throws SQLException {
        switch (crudChoice) {
            case 1:
                // Create Material
                System.out.println("Masukkan kode material:");
                String codeMaterial = scanner.nextLine();

                System.out.println("Masukkan deskripsi material:");
                String descMaterial = scanner.nextLine();

                System.out.println("Masukkan perusahaan material:");
                String compMaterial = scanner.nextLine();

                System.out.println("Masukkan tanggal pembuatan (format: yyyy-mm-dd):");
                String createdAtInput = scanner.nextLine();
                Date createdAt = java.sql.Date.valueOf(createdAtInput);

                Material material = new Material(codeMaterial, descMaterial, compMaterial, createdAt);
                materialDAO.create(material);
                System.out.println("Material created.");
                break;

            case 2:
                // Read Material
                System.out.println("Masukkan kode material yang ingin dibaca:");
                String readCodeMaterial = scanner.nextLine();

                Material readMaterial = materialDAO.read(readCodeMaterial);
                System.out.println(readMaterial);
                break;

            case 3:
                // Update Material
                System.out.println("Masukkan kode material yang ingin diperbarui:");
                String updateCodeMaterial = scanner.nextLine();

                System.out.println("Masukkan deskripsi material baru:");
                String newDescMaterial = scanner.nextLine();

                System.out.println("Masukkan perusahaan material baru:");
                String newCompMaterial = scanner.nextLine();

                System.out.println("Masukkan tanggal pembuatan baru (format: yyyy-mm-dd):");
                String newCreatedAtInput = scanner.nextLine();
                Date newCreatedAt = java.sql.Date.valueOf(newCreatedAtInput);

                Material updateMaterial = new Material(updateCodeMaterial, newDescMaterial, newCompMaterial, newCreatedAt);
                materialDAO.update(updateMaterial);
                System.out.println("Material updated.");
                break;

            case 4:
                // Delete Material
                System.out.println("Masukkan kode material yang ingin dihapus:");
                String deleteCodeMaterial = scanner.nextLine();

                materialDAO.delete(deleteCodeMaterial);
                System.out.println("Material deleted.");
                break;

            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }
}
