package service;

import vo.Phonebook;
import java.util.List;

public interface PhonebookService {
    int addPhonebook(Phonebook phonebook);
    List<Phonebook> getAllPhonebooks();
    List<Phonebook> searchPhonebooks(String search);
    Phonebook getPhonebookById(int id);
    int updatePhonebook(Phonebook phonebook);
    int deletePhonebook(int id);
}
