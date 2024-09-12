package dao;

import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import vo.Phonebook;

public class PhonebookDAOImpl implements PhonebookDAO {

    private JdbcTemplate jdbcTemplate;

    // Constructor Injection
    public PhonebookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Phonebook phonebook) {
        String sql = "INSERT INTO phonebook (id, name, hp, memo) VALUES (phonebook_id_seq.NEXTVAL, ?, ?, ?)";
        return jdbcTemplate.update(sql, phonebook.getName(), phonebook.getHp(), phonebook.getMemo());
    }

    @Override
    public List<Phonebook> selectAll() {
        String sql = "SELECT * FROM phonebook";
        return jdbcTemplate.query(sql, new PhonebookRowMapper());
    }

    @Override
    public List<Phonebook> search(String search) {
        String sql = "SELECT * FROM phonebook WHERE name LIKE ? OR hp LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + search + "%", "%" + search + "%"}, new PhonebookRowMapper());
    }

    @Override
    public Phonebook selectById(int id) {
        String sql = "SELECT * FROM phonebook WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PhonebookRowMapper());
    }

    @Override
    public int update(Phonebook phonebook) {
        String sql = "UPDATE phonebook SET name = ?, hp = ?, memo = ? WHERE id = ?";
        return jdbcTemplate.update(sql, phonebook.getName(), phonebook.getHp(), phonebook.getMemo(), phonebook.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM phonebook WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    private static final class PhonebookRowMapper implements RowMapper<Phonebook> {
        @Override
        public Phonebook mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Phonebook phonebook = new Phonebook();
            phonebook.setId(rs.getInt("id"));
            phonebook.setName(rs.getString("name"));
            phonebook.setHp(rs.getString("hp"));
            phonebook.setMemo(rs.getString("memo"));
            return phonebook;
        }
    }
}
