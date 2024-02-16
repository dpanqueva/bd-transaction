package com.invexdijin.bd.transaction.domain.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class AttemptsDocumentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createSchema() {
        try {
            createFunctionInitInsert();
            createTriggerInitInsert();
            createFunctionDelete();
            createTriggerInitDelete();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    private void createFunctionInitInsert() {
        String SQL = "CREATE OR REPLACE FUNCTION fn_insert_attempts_document() \n" +
                "   RETURNS TRIGGER \n" +
                "   LANGUAGE PLPGSQL\n" +
                "AS $$\n" +
                "BEGIN\n" +
                "   INSERT INTO attempts_document (document_type,document_number,search_date)\n" +
                "  \tVALUES (NEW.document_type,NEW.document_number,now());\n" +
                " RETURN NEW;\n" +
                "END;\n" +
                "$$\n" +
                ";";
        jdbcTemplate.execute(SQL);
    }

    private void createTriggerInitInsert() {
        String SQL = "CREATE OR REPLACE TRIGGER tr_insert_attempts_document\n" +
                "  BEFORE insert\n" +
                "  ON init_search\n" +
                "  FOR EACH ROW\n" +
                "  EXECUTE FUNCTION fn_insert_attempts_document();";

        jdbcTemplate.execute(SQL);
    }

    private void createFunctionDelete() {
        String SQL = "CREATE OR REPLACE FUNCTION fn_delete_attempts_document()\n" +
                "RETURNS TRIGGER \n" +
                "LANGUAGE PLPGSQL\n" +
                "AS $$\n" +
                "DECLARE\n" +
                "    v_document_type VARCHAR;\n" +
                "    v_document_number VARCHAR;\n" +
                "BEGIN\n" +
                "    IF NEW.payment_status = 'APPROVED' THEN\n" +
                "        SELECT ini.document_type, ini.document_number INTO v_document_type, v_document_number\n" +
                "        FROM init_search ini\n" +
                "        INNER JOIN payment p ON ini.init_search_id = p.init_search_id\n" +
                "        WHERE p.init_search_id = NEW.init_search_id;\n" +
                "       \n" +
                "        DELETE FROM attempts_document a\n" +
                "        WHERE a.document_type = v_document_type\n" +
                "        AND a.document_number = v_document_number;\n" +
                "    END IF;\n" +
                "    RETURN NEW;\n" +
                "END;\n" +
                "$$;";
        jdbcTemplate.execute(SQL);
    }

    private void createTriggerInitDelete() {
        String SQL = "CREATE OR REPLACE TRIGGER tr_delete_attempts_document\n" +
                "BEFORE UPDATE\n" +
                "ON payment\n" +
                "FOR EACH ROW\n" +
                "EXECUTE FUNCTION fn_delete_attempts_document();";

        jdbcTemplate.execute(SQL);

    }


}
