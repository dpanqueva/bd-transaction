CREATE FUNCTION fn_insert_attempts_document()
   RETURNS TRIGGER
   LANGUAGE PLPGSQL
AS $$
BEGIN
   INSERT INTO attempts_document (document_type,document_number)
  	VALUES (NEW.document_type,NEW.document_number);
 RETURN NEW;
END;
$$
;

CREATE TRIGGER tr_insert_attempts_document
  BEFORE insert
  ON init_search
  FOR EACH ROW
  EXECUTE PROCEDURE fn_insert_attempts_document();

