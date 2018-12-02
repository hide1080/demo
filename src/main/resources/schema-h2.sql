DROP TABLE IF EXISTS greeting;

CREATE TABLE greeting (
  id BIGINT NOT NULL,
  content VARCHAR(100),

  CONSTRAINT pk_greeting PRIMARY KEY (ID)
);