CREATE TABLE fields (
	ID INTEGER NOT NULL,
	Name VARCHAR (255) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE mathFigure (
	ID INTEGER NOT NULL,
	Name VARCHAR (255) NOT NULL,
	Description TEXT,
	URL VARCHAR (255),
	Field_ID INTEGER NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY (field_id) REFERENCES fields(id) 
);