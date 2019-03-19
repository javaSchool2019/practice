INSERT INTO ADDRESSES(country, city, street) VALUES ('Romania', 'Iasi', 'Palat, nr. 3');
INSERT INTO ADDRESSES(country, city, street) VALUES ('Romania', 'Iasi', 'Canta, nr. 3');
INSERT INTO ADDRESSES(country, city, street) VALUES ('Romania', 'Iasi', 'Canta, nr. 5');
INSERT INTO ADDRESSES(country, city, street) VALUES ('Romania', 'Iasi', 'Pacurari, nr. 8A');
INSERT INTO ADDRESSES(country, city, street) VALUES ('Romania', 'Bacau', 'Stefan cel mare, nr. 32');
INSERT INTO ADDRESSES(country, city, street) VALUES ('Romania', 'Bacau', 'Centru');

INSERT INTO PHONE_NUMBERS(number, provider) VALUES ('0700000001', 'Vodafone');
INSERT INTO PHONE_NUMBERS(number, provider) VALUES ('0700000002', 'Vodafone');
INSERT INTO PHONE_NUMBERS(number, provider) VALUES ('0700000003', 'Vodafone');
INSERT INTO PHONE_NUMBERS(number, provider) VALUES ('0700000004', 'Telekom');
INSERT INTO PHONE_NUMBERS(number, provider) VALUES ('0700000005', 'Telekom');
INSERT INTO PHONE_NUMBERS(number, provider) VALUES ('0700000006', 'Telekom');
INSERT INTO PHONE_NUMBERS(number, provider) VALUES ('0700000007', 'Orange');
INSERT INTO PHONE_NUMBERS(number, provider) VALUES ('0700000008', 'Orange');
INSERT INTO PHONE_NUMBERS(number, provider) VALUES ('0700000009', 'Orange');
INSERT INTO PHONE_NUMBERS(number, provider) VALUES ('0700000010', 'Orange');
INSERT INTO PHONE_NUMBERS(number, provider) VALUES ('0700000011', 'Orange');
INSERT INTO PHONE_NUMBERS(number, provider) VALUES ('0700000012', 'Orange');
INSERT INTO PHONE_NUMBERS(number, provider) VALUES ('0700000013', 'Orange');

--PERSONS
INSERT INTO YELLOW_PAGES(entry_type, address_id, first_name, last_name, activity_domain, company_name, operating_hours)
    VALUES ('P', 1, 'Razvan', 'Oprea', null, null, null);
INSERT INTO YELLOW_PAGES(entry_type, address_id, first_name, last_name, activity_domain, company_name, operating_hours)
    VALUES ('P', 2, 'Lucian', 'Cochior', null, null, null);
INSERT INTO YELLOW_PAGES(entry_type, address_id, first_name, last_name, activity_domain, company_name, operating_hours)
    VALUES ('P', 3, 'Cosmin', 'Gherasim', null, null, null);
INSERT INTO YELLOW_PAGES(entry_type, address_id, first_name, last_name, activity_domain, company_name, operating_hours)
    VALUES ('P', 4, 'Cosmin', 'Irimia', null, null, null);
INSERT INTO YELLOW_PAGES(entry_type, address_id, first_name, last_name, activity_domain, company_name, operating_hours)
    VALUES ('P', 5, 'David', 'Marcu', null, null, null);
INSERT INTO YELLOW_PAGES(entry_type, address_id, first_name, last_name, activity_domain, company_name, operating_hours)
    VALUES ('P', 6, 'Delia', 'Cazimir', null, null, null);
--COMPANIES
INSERT INTO YELLOW_PAGES(entry_type, address_id, first_name, last_name, activity_domain, company_name, operating_hours)
    VALUES ('C', 1, null, null, 'IT', 'Endava', '09-17');
INSERT INTO YELLOW_PAGES(entry_type, address_id, first_name, last_name, activity_domain, company_name, operating_hours)
    VALUES ('C', 4, null, null, 'IT', 'Amazon', '10-18');
INSERT INTO YELLOW_PAGES(entry_type, address_id, first_name, last_name, activity_domain, company_name, operating_hours)
    VALUES ('C', 4, null, null, 'Banking', 'Bcr', '09-17:30');
INSERT INTO YELLOW_PAGES(entry_type, address_id, first_name, last_name, activity_domain, company_name, operating_hours)
    VALUES ('C', 5, null, null, 'Sales', 'Adidas', '09-22');

INSERT INTO YELLOW_PAGES_PHONE_NUMBERS(yellow_page_entry_id, phone_numbers_id) VALUES (1, 1);
INSERT INTO YELLOW_PAGES_PHONE_NUMBERS(yellow_page_entry_id, phone_numbers_id) VALUES (1, 2);
INSERT INTO YELLOW_PAGES_PHONE_NUMBERS(yellow_page_entry_id, phone_numbers_id) VALUES (1, 3);
INSERT INTO YELLOW_PAGES_PHONE_NUMBERS(yellow_page_entry_id, phone_numbers_id) VALUES (2, 4);
INSERT INTO YELLOW_PAGES_PHONE_NUMBERS(yellow_page_entry_id, phone_numbers_id) VALUES (2, 13);
INSERT INTO YELLOW_PAGES_PHONE_NUMBERS(yellow_page_entry_id, phone_numbers_id) VALUES (3, 5);
INSERT INTO YELLOW_PAGES_PHONE_NUMBERS(yellow_page_entry_id, phone_numbers_id) VALUES (4, 6);
INSERT INTO YELLOW_PAGES_PHONE_NUMBERS(yellow_page_entry_id, phone_numbers_id) VALUES (5, 7);
INSERT INTO YELLOW_PAGES_PHONE_NUMBERS(yellow_page_entry_id, phone_numbers_id) VALUES (6, 8);
INSERT INTO YELLOW_PAGES_PHONE_NUMBERS(yellow_page_entry_id, phone_numbers_id) VALUES (7, 9);
INSERT INTO YELLOW_PAGES_PHONE_NUMBERS(yellow_page_entry_id, phone_numbers_id) VALUES (7, 10);
INSERT INTO YELLOW_PAGES_PHONE_NUMBERS(yellow_page_entry_id, phone_numbers_id) VALUES (8, 11);
INSERT INTO YELLOW_PAGES_PHONE_NUMBERS(yellow_page_entry_id, phone_numbers_id) VALUES (9, 12);