package Mobile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.xml.sax.SAXParseException;

import Operations.Operations;

public class Mobile extends Operations {
    private int id;
    private String brandName;
    private String modelName;
    private String operatingSystem;
    private int RAM;
    private int storage;
    private int battery;
    private String processor;
    private String camera;
    private String connectivity;
    private int price;

    public Mobile(int id, String brandName, String modelName, String operatingSystem, int rAM, int storage, int battery,
            String processor, String camera, String connectivity, int price) {
        this.id = id;
        this.brandName = brandName;
        this.modelName = modelName;
        this.operatingSystem = operatingSystem;
        this.RAM = rAM;
        this.storage = storage;
        this.battery = battery;
        this.processor = processor;
        this.camera = camera;
        this.connectivity = connectivity;
        this.price = price;
    }

    public Mobile(String mobLine) {

        String values[] = mobLine.split(",");
        this.id = Integer.parseInt(values[0]);
        this.brandName = values[1];
        this.modelName = values[2];
        this.operatingSystem = values[3];
        this.RAM = Integer.parseInt(values[4]);
        this.storage = Integer.parseInt(values[5]);
        this.battery = Integer.parseInt(values[6]);
        this.processor = values[7];
        this.camera = values[8];
        this.connectivity = values[9];
        this.price = Integer.parseInt(values[10]);
    }

    public Mobile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int rAM) {
        RAM = rAM;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorageIndex(int storage) {
        this.storage = storage;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + RAM;
        result = prime * result + battery;
        result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
        result = prime * result + ((camera == null) ? 0 : camera.hashCode());
        result = prime * result + ((connectivity == null) ? 0 : connectivity.hashCode());
        result = prime * result + id;
        result = prime * result + ((modelName == null) ? 0 : modelName.hashCode());
        result = prime * result + ((operatingSystem == null) ? 0 : operatingSystem.hashCode());
        result = prime * result + price;
        result = prime * result + ((processor == null) ? 0 : processor.hashCode());
        result = prime * result + storage;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mobile other = (Mobile) obj;
        if (RAM != other.RAM)
            return false;
        if (battery != other.battery)
            return false;
        if (brandName == null) {
            if (other.brandName != null)
                return false;
        } else if (!brandName.equals(other.brandName))
            return false;
        if (camera == null) {
            if (other.camera != null)
                return false;
        } else if (!camera.equals(other.camera))
            return false;
        if (connectivity == null) {
            if (other.connectivity != null)
                return false;
        } else if (!connectivity.equals(other.connectivity))
            return false;
        if (id != other.id)
            return false;
        if (modelName == null) {
            if (other.modelName != null)
                return false;
        } else if (!modelName.equals(other.modelName))
            return false;
        if (operatingSystem == null) {
            if (other.operatingSystem != null)
                return false;
        } else if (!operatingSystem.equals(other.operatingSystem))
            return false;
        if (price != other.price)
            return false;
        if (processor == null) {
            if (other.processor != null)
                return false;
        } else if (!processor.equals(other.processor))
            return false;
        if (storage != other.storage)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\n\tMobile- " + brandName + " " + modelName
                +"\nID\t\t\t:\t" + id 
                + "\nOperating System\t:\t" + operatingSystem
                + "\nRAM\t\t\t:\t" + RAM
                + " GB\nStorage\t\t\t:\t" + storage
                + " GB\nBattery\t\t\t:\t" + battery
                + " mAh\nProcessor\t\t:\t" + processor
                + "\nCamera\t\t\t:\t" + camera
                + " MP\nConnectivity\t\t:\t" + connectivity
                + "\nPrice\t\t\t:\t" + price + " INR" + "\n";
    }

    @Override
    public void createTable() {
        try {
            MobileDAO.createMobileTable();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addData(String S) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(S));
            String mobLine;
            while ((mobLine = reader.readLine()) != null) {
                MobileDAO.createMobile(new Mobile(mobLine));
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String id, String update, String updated) {
        Mobile mobile = MobileDAO.getMobile("id", id).get(0);
        try {
            MobileDAO.updateMobile(mobile, update, updated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInBulk(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String mobLine;
            while ((mobLine = reader.readLine()) != null) {
                String values[] = mobLine.split(",");
                this.update(values[0], values[1], values[2]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            MobileDAO.deleteMobile(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printAll() {
        List<Mobile> allMobiles = MobileDAO.getAllMobile();
        allMobiles.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void printByAttribute(String attribute, String value) {
        Mobile mobile = MobileDAO.getMobile(attribute, value).get(0);
        System.out.println(mobile);
    }

    @Override
    public void search(String attribute, String value) {
        List<Mobile> mobiles = MobileDAO.getMobile(attribute, value);
        mobiles.forEach(System.out::println);
    }
}
