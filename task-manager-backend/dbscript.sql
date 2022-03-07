CREATE DATABASE task_manager;

CREATE TABLE tasks(task_id SERIAL PRIMARY KEY, 
					task_name VARCHAR(50),
					created_by INT,
					completed BOOLEAN,
					created_on TIMESTAMP DEFAULT NOW(),
					updated_on TIMESTAMP
					)
						
INSERT INTO tasks(task_name, created_by, completed)
						VALUES('Create endpoints that work', 1, true);

INSERT INTO tasks(task_name, created_by, completed)
						VALUES('Update my partner', 1, false);
						
INSERT INTO tasks(task_name, created_by, completed)
						VALUES('Create even better backend', 1, false);
						
INSERT INTO tasks(task_name, created_by, completed)
						VALUES('Test for deleting', 1, true);


									
									