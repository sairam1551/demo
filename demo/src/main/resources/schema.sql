CREATE TABLE dc_individual (
    indv_id VARCHAR(20) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL
);

CREATE TABLE dc_case (
    case_num VARCHAR(20) PRIMARY KEY,
    status VARCHAR(20) NOT NULL,
    is_head_of_household BOOLEAN NOT NULL
);

CREATE TABLE dc_case_individual (
    case_num VARCHAR(20) NOT NULL,
    indv_id VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    is_head_of_household BOOLEAN NOT NULL,
    PRIMARY KEY (case_num, indv_id),
    FOREIGN KEY (case_num) REFERENCES dc_case(case_num),
    FOREIGN KEY (indv_id) REFERENCES dc_individual(indv_id)
);

CREATE TABLE dc_program_enrollment (
    case_num VARCHAR(20) NOT NULL,
    program_cd VARCHAR(20) NOT NULL,
    PRIMARY KEY (case_num, program_cd),
    FOREIGN KEY (case_num) REFERENCES dc_case(case_num)
);