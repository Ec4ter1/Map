package Repository;

import domain.Entity;
import domain.validator.Validator;

import java.io.*;
import java.util.List;

public abstract class AbstractFileRepository<ID, E extends Entity<ID>> extends InMemoryRepository<ID, E> {
    String fileName;

    public AbstractFileRepository(String fileName, Validator<E> validator) {
        super(validator);
        this.fileName = fileName;
        loadData();
    }

    public void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linie;

            while ((linie = br.readLine()) != null) {
                String[] date = linie.split(";");
                E entity = extractEntity(date);
                entities.put(entity.getId(), entity);
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului: " + e.getMessage());
        }
    }

    @Override
    public E save(E entity) {
        E result = super.save(entity);
        if (result == null)
            storeToFile();
        return result;

    }

    @Override
    public E delete(ID id) {
        E result = super.delete(id);
        if (result != null)
            storeToFile();
        return result;
    }

    public abstract E extractEntity(String[] attributes);


    protected abstract String createEntityAsString(E entity);

    protected void storeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
            for(E entity : entities.values()) {
                writer.write(createEntityAsString(entity));
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
