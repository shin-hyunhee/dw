package dao;

import vo.Phonebook;
import java.util.List;

public interface PhonebookDAO {
    int insert(Phonebook phonebook);
    List<Phonebook> selectAll();
    List<Phonebook> search(String _search);
    Phonebook selectById(int id);
    int update(Phonebook phonebook);
    int delete(int id);
}
