-- =======================================
-- INSERT: Individuals
-- =======================================
INSERT INTO dc_individual (indv_id, first_name) VALUES ('I100', 'John');
INSERT INTO dc_individual (indv_id, first_name) VALUES ('I101', 'Mary');
INSERT INTO dc_individual (indv_id, first_name) VALUES ('I102', 'David');
INSERT INTO dc_individual (indv_id, first_name) VALUES ('I103', 'Sarah');
INSERT INTO dc_individual (indv_id, first_name) VALUES ('I104', 'Mike');

-- =======================================
-- INSERT: Cases
-- =======================================
INSERT INTO dc_case (case_num, status, is_head_of_household)
VALUES ('C200', 'APPROVED', TRUE);

INSERT INTO dc_case (case_num, status, is_head_of_household)
VALUES ('C201', 'APPROVED', FALSE);

INSERT INTO dc_case (case_num, status, is_head_of_household)
VALUES ('C202', 'APPROVED', FALSE);

INSERT INTO dc_case (case_num, status, is_head_of_household)
VALUES ('C203', 'PENDING', TRUE);

INSERT INTO dc_case (case_num, status, is_head_of_household)
VALUES ('C204', 'APPROVED', TRUE);

-- =======================================
-- INSERT: Case-Individual Links
-- =======================================
-- Case C200: John (Head), enrolled in SNAP (FS)
INSERT INTO dc_case_individual (case_num, indv_id, status, is_head_of_household)
VALUES ('C200', 'I100', 'ACTIVE', TRUE);

-- Case C201: Mary (Not head), enrolled in CASH
INSERT INTO dc_case_individual (case_num, indv_id, status, is_head_of_household)
VALUES ('C201', 'I101', 'ACTIVE', FALSE);

-- Case C202: David (Not head), enrolled in TF
INSERT INTO dc_case_individual (case_num, indv_id, status, is_head_of_household)
VALUES ('C202', 'I102', 'ACTIVE', FALSE);

-- Case C203: Sarah (Head), but case is PENDING - should NOT appear in results
INSERT INTO dc_case_individual (case_num, indv_id, status, is_head_of_household)
VALUES ('C203', 'I103', 'ACTIVE', TRUE);

-- Case C204: Mike (Head), enrolled in BOTH SNAP and CASH
INSERT INTO dc_case_individual (case_num, indv_id, status, is_head_of_household)
VALUES ('C204', 'I104', 'ACTIVE', TRUE);

-- =======================================
-- INSERT: Program Enrollments
-- =======================================
-- C200 enrolled in SNAP (FS)
INSERT INTO dc_program_enrollment (case_num, program_cd)
VALUES ('C200', 'FS');

-- C201 enrolled in CASH
INSERT INTO dc_program_enrollment (case_num, program_cd)
VALUES ('C201', 'CASH');

-- C202 enrolled in TF
INSERT INTO dc_program_enrollment (case_num, program_cd)
VALUES ('C202', 'TF');

-- C203 enrolled in SNAP (but case is PENDING)
INSERT INTO dc_program_enrollment (case_num, program_cd)
VALUES ('C203', 'FS');

-- C204 enrolled in BOTH SNAP and CASH
INSERT INTO dc_program_enrollment (case_num, program_cd)
VALUES ('C204', 'FS');

INSERT INTO dc_program_enrollment (case_num, program_cd)
VALUES ('C204', 'CASH');