create table region(
	region_id serial primary key,
	region_name varchar(30),
  last_update_date date,
  last_update_by varchar(20)
)

create table country(
	country_cd int primary key,
	country_name varchar(30),
	region_id int,
  last_update_date date,
  last_update_by varchar(20)
	constraint fk
	foreign key (region_id)
	references region(region_id)
)

create table department(
	dept_id int primary key,
	dept_name varchar(30),
  last_update_date date,
  last_update_by varchar(20)
)

create table job_types(
	  job_type_cd int primary key,
	  job_type_name varchar(30),
	  last_update_date date,
	  last_update_by varchar(20)
)

create table job_types(
	  job_type_cd int primary key,
	  job_type_name varchar(30),
	  last_update_date date,
	  last_update_by varchar(20)
)

create table job_status_codes(
	  job_status_cd int primary key,
	  status_desc varchar(30),
	  last_update_date date,
	  last_update_by varchar(20)
)
  
create table apply_status_codes(
	  apply_status_cd int primary key,
	  status_desc varchar(30),
	  last_update_date date,
	  last_update_by varchar(20)
)

create table education_levels(
	  edu_level_cd int primary key,
	  edu_level_name varchar(30),
	  last_update_date date,
	  last_update_by varchar(20)
)

create table education_type(
	  edu_type_cd int primary key,
	  edu_type_name varchar(30),
	  last_update_date date,
	  last_update_by varchar(20)
)


create table jobs(
	  job_id int primary key,
	  job_title varchar(30),
	  job_desc varchar(4000),
	  job_type_cd int,
	  dept_id int,
	  job_status_cd int,
	  country_cd int,
	  date_opened date,
	  date_closed date,
	  last_update_date date,
	  last_update_by varchar(20),
	  constraint fk
	  foreign key (job_type_cd)
	  references job_types(job_type_cd),
	foreign key (dept_id)
	  references department(dept_id),
	foreign key (job_status_cd)
	  references job_status_codes(job_status_cd),
	foreign key (country_cd)
	  references country(country_cd)
)

create sequence app_id_seq start 1;
create table applicants(
	  appl_id int primary key default nextval('app_id_seq'),
	  first_name varchar(30),
	  last_name varchar(30),
	  email varchar(30),
	  phone_num varchar(30),
	  address varchar(50),
	  city varchar(30),
	  state_name varchar(30),
	  zip varchar(30),
	  country_cd int,
	  apply_status_cd int,
	  edu_level_cd int,
	  edu_type_cd int,
	  resume_file_name bytea,
	  cover_letter_text varchar(50),
	  date_applied date,
	  employed_flag bool,
	  current_employer_name varchar(30),
	  years_of_experience int,
	  last_update_date date,
	  last_update_by varchar(20),
	  constraint fk
	  foreign key (apply_status_cd)
	  references apply_status_codes(apply_status_cd),
	foreign key (edu_level_cd)
	  references education_levels(edu_level_cd),
	foreign key (edu_type_cd)
	  references education_type(edu_type_cd),
	foreign key (country_cd)
	  references country(country_cd)
)


create table applicant_jobs(
	  appl_id int,
      job_id int,
	  apply_status_cd int,
	  date_applied date,
      written_test_date date,
      interview1_date date,
      interview2_date date,
	  last_update_date date,
	  last_update_by varchar(20),
	  constraint fk
    primary key(appl_id,job_id),
	  foreign key (apply_status_cd)
	  references apply_status_codes(apply_status_cd),
	foreign key (appl_id)
	  references applicants(appl_id),
	foreign key (job_id)
	  references jobs(job_id)
)



