# project-tambang
Pewarisan Sifat (Inheritance) dalam Java untuk dua class, yaitu Material dan Location. membuat dua class dasar Material dan Location, dan kemudian membuat class turunan yang mewarisi sifat-sifat dari kedua class ini.


>[!TIP]
>Ini link google drive [Google Drive/Project-tambang](https://drive.google.com/drive/folders/1SCdykxUFIJ-tHOmNKX5tnV7WnQJZwpoq?usp=sharing)
 
![GitHub repo size](https://img.shields.io/github/repo-size/ahmadsyaifuddin-99/project-tambang)

## Path Dir Files:

```haskell
project-tambang/
├───build
│   ├───classes
│   │   ├───asai
│   │   │   └───project
│   │   │       └───model
│   │   ├───asai_project_model
│   │   ├───CRUD
│   │   ├───project
│   │   │   └───tambang
│   │   ├───project_tambang
│   │   └───tambang_DAO
│   ├───empty
│   └───generated-sources
│       └───ap-source-output
├───dist
│   └───lib
├───nbproject
│   └───private
├───src
│   ├───asai_project_model
│   ├───CRUD
│   ├───project_tambang
│   └───tambang_DAO
└───test
```

In deep dir src
```css
project-tambang
│
├── src
│   ├── asai_project_model
│   │   ├── CoalGetting.java
│   │   ├── Company.java
│   │   ├── Location.java
│   │   └── Material.java
│   │
│   ├── project_tambang
│   │   └── Main.java
│   │
│   └── tambang_DAO
│       ├── CoalGettingDAO.java
│       ├── CompanyDAO.java
│       ├── LocationDAO.java
│       └── MaterialDAO.java
│
└── CRUD
    └── DatabaseConnection.java
```

## Berikut penjelasan dari fungsi codingannya :

## Class Material.java
```haskell
package asai.project.model;

public class Material {
    private String name;
    private double density;

    public Material(String name, double density) {
        this.name = name;
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return "Material{name='" + name + "', density=" + density + "}";
    }
}
```
### Penjelasan:
<li>Attributes: name (nama material) dan density (densitas material).</li>
<li>Constructor: Menginisialisasi name dan density saat objek Material dibuat.</li>
<li>Getters and Setters: Metode untuk mendapatkan dan mengubah nilai name dan density.
</li>
<li>toString: Mengembalikan representasi string dari objek Material.
</li>

## Class Location.java

```haskell
package asai.project.model;

public class Location {
    private String address;
    private String city;

    public Location(String address, String city) {
        this.address = address;
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{address='" + address + "', city='" + city + "'}";
    }
}
```

### Penjelasan:
<li>
Attributes: address (alamat lokasi) dan city (kota lokasi).</li>
<li>Constructor: Menginisialisasi address dan city saat objek Location dibuat.
</li>
<li>Getters and Setters: Metode untuk mendapatkan dan mengubah nilai address dan city.
</li>
<li>toString: Mengembalikan representasi string dari objek Location.
</li>

## Class MaterialLocation.java
```haskell
package asai.project.model;

public class MaterialLocation extends Material {
    private Location location;

    public MaterialLocation(String name, double density, String address, String city) {
        super(name, density);
        this.location = new Location(address, city);
    }

    public String getAddress() {
        return location.getAddress();
    }

    public void setAddress(String address) {
        location.setAddress(address);
    }

    public String getCity() {
        return location.getCity();
    }

    public void setCity(String city) {
        location.setCity(city);
    }

    @Override
    public String toString() {
        return "MaterialLocation{" +
                "name='" + getName() + '\'' +
                ", density=" + getDensity() +
                ", address='" + getAddress() + '\'' +
                ", city='" + getCity() + '\'' +
                '}';
    }
}

```

### Penjelasan:
<li>
Inheritance: MaterialLocation adalah subclass dari Material, sehingga mewarisi atribut dan metode dari Material.
</li>
<li>Attributes: location (objek Location yang mewakili alamat dan kota).
</li>
<li>Constructor: Menginisialisasi atribut name dan density menggunakan konstruktor superclass (Material) dan menginisialisasi location dengan objek Location baru.
</li>
<li>Getters and Setters: Metode untuk mendapatkan dan mengubah nilai address dan city dari objek Location.
</li>
<li>toString: Mengembalikan representasi string dari objek MaterialLocation, termasuk atribut yang diwarisi dari Material dan atribut location.
</li>


## Class Main.java (Full)

```haskell

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project.tambang;

/**
 *
 * @author User
 */

import asai.project.model.MaterialLocation;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Input untuk Material
        try (Scanner scanner = new Scanner(System.in)) {
            // Input untuk Material
            System.out.println("Masukkan nama material:");
            String name = scanner.nextLine();
            
            System.out.println("Masukkan densitas material:");
            double density = scanner.nextDouble();
            scanner.nextLine();  // Clear the buffer
            
            // Input untuk Location
            System.out.println("Masukkan alamat lokasi:");
            String address = scanner.nextLine();
            
            System.out.println("Masukkan kota lokasi:");
            String city = scanner.nextLine();
            
            // Membuat objek MaterialLocation dengan data yang diinputkan
            MaterialLocation materialLocation = new MaterialLocation(name, density, address, city);
            System.out.println(materialLocation);
            
            // Mengubah alamat
            System.out.println("Masukkan alamat baru:");
            String newAddress = scanner.nextLine();
            materialLocation.setAddress(newAddress);
            System.out.println("Updated Address: " + materialLocation.getAddress());
            
            // Mengubah kota
            System.out.println("Masukkan kota baru:");
            String newCity = scanner.nextLine();
            materialLocation.setCity(newCity);
            System.out.println("Updated City: " + materialLocation.getCity());
        }
    }
}

```

### Penjelasan Detail untuk Code Class Main.java:
### Header dan Package Declaration
```haskell
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project.tambang;
```
<li>Komentar: Ini adalah komentar yang dibuat secara otomatis oleh NetBeans saat membuat file Java baru. Komentar ini menunjukkan lokasi template lisensi dan template kelas.
</li>
<li>Package Declaration: Menyatakan bahwa kelas Main berada dalam paket project.tambang.</li>

### Import Statements
```haskell
import asai.project.model.MaterialLocation;
import java.util.Scanner;
```
<li>import asai.project.model.MaterialLocation; Mengimpor kelas MaterialLocation dari paket asai.project.model
</li>
<li>import java.util.Scanner; Mengimpor kelas Scanner dari paket java.util untuk membaca input dari pengguna
</li>

### Deklarasi Kelas Main
```haskell
/**
 *
 * @author User
 */

public class Main {
    public static void main(String[] args) {

```
<li>Javadoc Comment: Komentar ini bisa digunakan untuk memberikan informasi tambahan tentang kelas atau penulisnya.
</li>
<li>Deklarasi Kelas: public class Main mendeklarasikan kelas Main.
</li>
<li>Metode Main: public static void main(String[] args) adalah titik masuk utama dari aplikasi Java.
</li>

### Penggunaan Scanner dengan try-with-resources
```haskell
        try (Scanner scanner = new Scanner(System.in)) {
```
<li>try-with-resources: Blok ini memastikan bahwa objek Scanner akan ditutup secara otomatis setelah digunakan, yang merupakan praktik yang baik untuk mengelola sumber daya.
</li>

### Input untuk Material
```haskell
            // Input untuk Material
            System.out.println("Masukkan nama material:");
            String name = scanner.nextLine();
            
            System.out.println("Masukkan densitas material:");
            double density = scanner.nextDouble();
            scanner.nextLine();  // Clear the buffer
```
<li>System.out.println("Masukkan nama material:");: Menampilkan pesan untuk meminta pengguna memasukkan nama material.
</li>
<li>String name = scanner.nextLine();: Membaca input nama material dari pengguna.
</li>
<li>System.out.println("Masukkan densitas material:");: Menampilkan pesan untuk meminta pengguna memasukkan densitas material.
</li>
<li>double density = scanner.nextDouble();: Membaca input densitas material dari pengguna.
</li>
<li>scanner.nextLine(); // Clear the buffer: Membersihkan buffer input setelah membaca nilai double. Ini diperlukan karena nextDouble tidak mengkonsumsi karakter newline (\n), sehingga kita perlu memanggil nextLine untuk mengosongkan buffer.
</li>

### Input untuk Location
```haskell
            // Input untuk Location
            System.out.println("Masukkan alamat lokasi:");
            String address = scanner.nextLine();
            
            System.out.println("Masukkan kota lokasi:");
            String city = scanner.nextLine();
```
<li>System.out.println("Masukkan alamat lokasi:");: Menampilkan pesan untuk meminta pengguna memasukkan alamat lokasi.
</li>
<li>String address = scanner.nextLine();: Membaca input alamat dari pengguna.
</li>
<li>System.out.println("Masukkan kota lokasi:");: Menampilkan pesan untuk meminta pengguna memasukkan kota lokasi.
</li>
<li>String city = scanner.nextLine();: Membaca input kota dari pengguna.
</li>

### Membuat dan Menampilkan Objek MaterialLocation
```haskell
            // Membuat objek MaterialLocation dengan data yang diinputkan
            MaterialLocation materialLocation = new MaterialLocation(name, density, address, city);
            System.out.println(materialLocation);
```
<li>MaterialLocation materialLocation = new MaterialLocation(name, density, address, city);: Membuat objek MaterialLocation dengan data yang diinputkan oleh pengguna.
</li>
<li>System.out.println(materialLocation);: Menampilkan representasi string dari objek MaterialLocation. Metode toString di MaterialLocation akan dipanggil untuk menghasilkan output ini.
</li>

### Mengubah Alamat
```haskell
            // Mengubah alamat
            System.out.println("Masukkan alamat baru:");
            String newAddress = scanner.nextLine();
            materialLocation.setAddress(newAddress);
            System.out.println("Updated Address: " + materialLocation.getAddress());
```
<li>System.out.println("Masukkan alamat baru:");: Menampilkan pesan untuk meminta pengguna memasukkan alamat baru.
</li>
<li>String newAddress = scanner.nextLine();: Membaca input alamat baru dari pengguna.
</li>
<li>materialLocation.setAddress(newAddress);: Mengubah alamat dalam objek MaterialLocation dengan alamat baru yang diinputkan.
</li>
<li>System.out.println("Updated Address: " + materialLocation.getAddress());: Menampilkan alamat yang telah diperbarui.
</li>

### Mengubah Kota
```haskell
            // Mengubah kota
            System.out.println("Masukkan kota baru:");
            String newCity = scanner.nextLine();
            materialLocation.setCity(newCity);
            System.out.println("Updated City: " + materialLocation.getCity());
        }
```
<li>System.out.println("Masukkan kota baru:");: Menampilkan pesan untuk meminta pengguna memasukkan kota baru.
</li>
<li>String newCity = scanner.nextLine();: Membaca input kota baru dari pengguna.
</li>
<li>materialLocation.setCity(newCity);: Mengubah kota dalam objek MaterialLocation dengan kota baru yang diinputkan.
</li>
<li>System.out.println("Updated City: " + materialLocation.getCity());: Menampilkan kota yang telah diperbarui.
</li>

### Menutup try-with-resources
```haskell
    }
}
```
<li>Menutup blok try-with-resources: Objek Scanner akan ditutup secara otomatis ketika blok try selesai dieksekusi, memastikan pengelolaan sumber daya yang baik.
</li>

## Ringkasan 
<p>Kode ini memungkinkan pengguna untuk memasukkan data material dan lokasi melalui konsol, membuat objek MaterialLocation dengan data tersebut, menampilkan informasi objek, dan kemudian memperbarui serta menampilkan alamat dan kota baru. Penggunaan try-with-resources memastikan bahwa Scanner ditutup dengan benar setelah digunakan.
</p>

