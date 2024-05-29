# project-tambang
Pewarisan Sifat (Inheritance) dalam Java untuk dua class, yaitu Material dan Location. membuat dua class dasar Material dan Location, dan kemudian membuat class turunan yang mewarisi sifat-sifat dari kedua class ini.


>[!TIP]
>Ini link google drive [Google Drive/Project-tambang](https://drive.google.com/drive/folders/1SCdykxUFIJ-tHOmNKX5tnV7WnQJZwpoq?usp=sharing)
 
![GitHub repo size](https://img.shields.io/github/repo-size/ahmadsyaifuddin-99/project-tambang)

## Path Dir Files:

```
project-tambang/
├───build
│   └───classes
│       ├───asai
│       │   └───project
│       │       └───model
│       └───project
│           └───tambang
├───nbproject
│   └───private
├───src
│   ├───asai
│   │   └───project
│   │       └───model
│   └───project
│       └───tambang
└───test


In deep dir src

project-tambang/
|-- src/
    |-- main/
        |-- java/
            |-- asai/
                |-- project/
                    |-- model/
                        |-- Material.java
                        |-- Location.java
                        |-- MaterialLocation.java
            |-- project/
                |-- tambang/
                    |-- Main.java

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

## Class Location

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

## Class MaterialLocation
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

# Class Main
```haskell
package asai.project.model;

import asai.project.model.MaterialLocation;

public class Main {
    public static void main(String[] args) {
        MaterialLocation materialLocation = new MaterialLocation("Steel", 7.85, "123 Industrial Rd", "Metaltown");
        System.out.println(materialLocation);

        // Mengubah alamat
        materialLocation.setAddress("456 Manufacturing Ave");
        System.out.println("Updated Address: " + materialLocation.getAddress());

        // Mengubah kota
        materialLocation.setCity("New Metaltown");
        System.out.println("Updated City: " + materialLocation.getCity());
    }
}

```

### Penjelasan:
<li>
Package Declaration: Menyatakan bahwa kelas Main berada dalam paket asai.project.model.
</li>
<li>Import Statement: Mengimpor kelas MaterialLocation dari paket asai.project.model.
</li>
<li>Main Method: Titik masuk program yang akan dijalankan saat program dimulai.
</li>
<li>MaterialLocation Object Creation: Membuat objek MaterialLocation dengan nama "Steel", densitas 7.85, alamat "123 Industrial Rd", dan kota "Metaltown".
</li>
<li>Printing Initial State: Mencetak representasi string dari objek MaterialLocation.
</li>
<li>Updating Address: Mengubah alamat menjadi "456 Manufacturing Ave" dan mencetak alamat yang diperbarui.
</li>
<li>Updating City: Mengubah kota menjadi "New Metaltown" dan mencetak kota yang diperbarui.
</li>
