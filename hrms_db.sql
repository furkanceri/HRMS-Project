DROP SCHEMA public CASCADE;
CREATE SCHEMA public;


CREATE TABLE public.activation_code
(
    id integer NOT NULL,
    verification_code integer NOT NULL,
    is_valid boolean NOT NULL,
    verification_date date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.company_staff
(
    company_staff_id integer NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    starting_date_of_work date NOT NULL,
    department character varying(50) NOT NULL,
    task character varying(50) NOT NULL,
    PRIMARY KEY (company_staff_id)
);

CREATE TABLE public.employers
(
    employers_id integer NOT NULL,
    company_name character varying(20) NOT NULL,
    web_site character varying(30) NOT NULL,
    phone_number character varying(11) NOT NULL,
	company_email character varying(30) NOT NULL,
    PRIMARY KEY (employers_id)
);

CREATE TABLE public.employers_verification_by_company_staff
(
    employers_id integer NOT NULL,
    company_staff_id integer NOT NULL,
    is_valid boolean NOT NULL,
    PRIMARY KEY (company_staff_id)
);

CREATE TABLE public.employers_verification_by_employers
(
    verification_id integer NOT NULL,
    employers_id integer NOT NULL,
    PRIMARY KEY (verification_id)
);

CREATE TABLE public.job_seekers
(
    job_seekers_id integer NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(25) NOT NULL,
    birth_year character(4) NOT NULL,
    nationality_id character(11) NOT NULL,
    PRIMARY KEY (job_seekers_id)
);

CREATE TABLE public.job_seekers_verification
(
    verification_id integer NOT NULL,
    job_seekers_id integer NOT NULL,
    PRIMARY KEY (verification_id)
);

CREATE TABLE public.jobs
(
    id integer NOT NULL,
    business_sector character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id integer NOT NULL,
    email character varying(30) NOT NULL,
    password character varying(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE SEQUENCE "public"."activation_code_id_seq" 
    INCREMENT BY 1 START WITH 1 
    OWNED BY "public"."activation_code"."id";
	
CREATE SEQUENCE "public"."users_id_seq" 
    INCREMENT BY 1 START WITH 1 
    OWNED BY "public"."users"."id";
	
CREATE SEQUENCE "public"."jobs_id_seq" 
    INCREMENT BY 1 START WITH 1 
    OWNED BY "public"."jobs"."id";

ALTER TABLE public.company_staff
    ADD FOREIGN KEY (company_staff_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employers
    ADD FOREIGN KEY (employers_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employers_verification_by_company_staff
    ADD FOREIGN KEY (company_staff_id)
    REFERENCES public.company_staff (company_staff_id)
    NOT VALID;


ALTER TABLE public.employers_verification_by_company_staff
    ADD FOREIGN KEY (employers_id)
    REFERENCES public.employers (employers_id)
    NOT VALID;


ALTER TABLE public.employers_verification_by_employers
    ADD FOREIGN KEY (employers_id)
    REFERENCES public.employers (employers_id)
    NOT VALID;


ALTER TABLE public.employers_verification_by_employers
    ADD FOREIGN KEY (verification_id)
    REFERENCES public.activation_code (id)
    NOT VALID;


ALTER TABLE public.job_seekers
    ADD FOREIGN KEY (job_seekers_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.job_seekers_verification
    ADD FOREIGN KEY (job_seekers_id)
    REFERENCES public.job_seekers (job_seekers_id)
    NOT VALID;


ALTER TABLE public.job_seekers_verification
    ADD FOREIGN KEY (verification_id)
    REFERENCES public.activation_code (id)
    NOT VALID;
	
	
ALTER TABLE public.users
    ADD CONSTRAINT "uk_users_email"
    UNIQUE ("email");

ALTER TABLE public.job_seekers
    ADD CONSTRAINT "uk_job_sekeers_nationality_id"
    UNIQUE ("nationality_id");

ALTER TABLE public.employers
    ADD CONSTRAINT "uk_employers_web_site"
    UNIQUE ("web_site");
	
ALTER TABLE public.employers
	ADD CONSTRAINT "uk_employers_email"
	UNIQUE ("company_email");