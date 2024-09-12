package service;

import java.util.List;

import dao.PhonebookDAO;
import vo.Phonebook;

public class PhonebookServiceImpl implements PhonebookService {

    private PhonebookDAO phonebookDAO;

    // Constructor Injection
    public PhonebookServiceImpl(PhonebookDAO phonebookDAO) {
        this.phonebookDAO = phonebookDAO;
    }

    @Override
    public int addPhonebook(Phonebook phonebook) {
        return phonebookDAO.insert(phonebook);
    }

    @Override
    public List<Phonebook> getAllPhonebooks() {
        return phonebookDAO.selectAll();
    }

    @Override
    public List<Phonebook> searchPhonebooks(String search) {
        return phonebookDAO.search(search);
    }

    @Override
    public Phonebook getPhonebookById(int id) {
        return phonebookDAO.selectById(id);
    }

    @Override
    public int updatePhonebook(Phonebook phonebook) {
        return phonebookDAO.update(phonebook);
    }

    @Override
    public int deletePhonebook(int id) {
        return phonebookDAO.delete(id);
    }
}
