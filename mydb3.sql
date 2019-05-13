--
-- PostgreSQL database dump
--

-- Dumped from database version 10.7
-- Dumped by pg_dump version 10.7

-- Started on 2019-05-13 17:36:17

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2856 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 24641)
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    id integer NOT NULL,
    title text NOT NULL,
    cost integer NOT NULL,
    storage text NOT NULL,
    count integer NOT NULL
);


ALTER TABLE public.book OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 24639)
-- Name: book_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.book_id_seq OWNER TO postgres;

--
-- TOC entry 2857 (class 0 OID 0)
-- Dependencies: 196
-- Name: book_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.book_id_seq OWNED BY public.book.id;


--
-- TOC entry 199 (class 1259 OID 24652)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    id integer NOT NULL,
    surname text NOT NULL,
    district text NOT NULL,
    discount integer NOT NULL
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 24650)
-- Name: customer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_id_seq OWNER TO postgres;

--
-- TOC entry 2858 (class 0 OID 0)
-- Dependencies: 198
-- Name: customer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customer_id_seq OWNED BY public.customer.id;


--
-- TOC entry 203 (class 1259 OID 24674)
-- Name: purchase; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.purchase (
    id integer NOT NULL,
    date date NOT NULL,
    shop integer NOT NULL,
    customer integer NOT NULL,
    book integer NOT NULL,
    number integer NOT NULL,
    total integer
);


ALTER TABLE public.purchase OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24672)
-- Name: purchase_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.purchase_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.purchase_id_seq OWNER TO postgres;

--
-- TOC entry 2859 (class 0 OID 0)
-- Dependencies: 202
-- Name: purchase_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.purchase_id_seq OWNED BY public.purchase.id;


--
-- TOC entry 205 (class 1259 OID 24699)
-- Name: purchasee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.purchasee (
    id integer NOT NULL,
    date date NOT NULL,
    shop integer NOT NULL,
    customer integer NOT NULL,
    book integer NOT NULL,
    number integer NOT NULL,
    total integer NOT NULL
);


ALTER TABLE public.purchasee OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24697)
-- Name: purchasee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.purchasee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.purchasee_id_seq OWNER TO postgres;

--
-- TOC entry 2860 (class 0 OID 0)
-- Dependencies: 204
-- Name: purchasee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.purchasee_id_seq OWNED BY public.purchasee.id;


--
-- TOC entry 201 (class 1259 OID 24663)
-- Name: shop; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.shop (
    id integer NOT NULL,
    title text NOT NULL,
    district text NOT NULL,
    comission integer
);


ALTER TABLE public.shop OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 24661)
-- Name: shop_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.shop_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.shop_id_seq OWNER TO postgres;

--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 200
-- Name: shop_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.shop_id_seq OWNED BY public.shop.id;


--
-- TOC entry 2697 (class 2604 OID 24644)
-- Name: book id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book ALTER COLUMN id SET DEFAULT nextval('public.book_id_seq'::regclass);


--
-- TOC entry 2698 (class 2604 OID 24655)
-- Name: customer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer ALTER COLUMN id SET DEFAULT nextval('public.customer_id_seq'::regclass);


--
-- TOC entry 2700 (class 2604 OID 24677)
-- Name: purchase id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase ALTER COLUMN id SET DEFAULT nextval('public.purchase_id_seq'::regclass);


--
-- TOC entry 2701 (class 2604 OID 24702)
-- Name: purchasee id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchasee ALTER COLUMN id SET DEFAULT nextval('public.purchasee_id_seq'::regclass);


--
-- TOC entry 2699 (class 2604 OID 24666)
-- Name: shop id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shop ALTER COLUMN id SET DEFAULT nextval('public.shop_id_seq'::regclass);


--
-- TOC entry 2840 (class 0 OID 24641)
-- Dependencies: 197
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.book VALUES (3, 'Windows. Part one', 15000, 'Nizhegorodskiy', 100);
INSERT INTO public.book VALUES (4, 'Harry Potter', 23000, 'Sormovskiy', 5);
INSERT INTO public.book VALUES (5, 'Open Windows', 25000, 'Sovetskiy', 20);
INSERT INTO public.book VALUES (6, 'Anna Karenina', 10000, 'Autozavodskiy', 20);
INSERT INTO public.book VALUES (7, 'War and Peace', 50000, 'Nizhegorodskiy', 12);


--
-- TOC entry 2842 (class 0 OID 24652)
-- Dependencies: 199
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.customer VALUES (1, 'Kurkin', 'Sormovskiy', 15);
INSERT INTO public.customer VALUES (2, 'Kurkina', 'Sormovskiy', 12);
INSERT INTO public.customer VALUES (3, 'Ivanov', 'Sovetskiy', 0);
INSERT INTO public.customer VALUES (4, 'Petrov', 'Nizhegorodskiy', 5);
INSERT INTO public.customer VALUES (5, 'Sidorov', 'Nizhegorodskiy', 9);


--
-- TOC entry 2846 (class 0 OID 24674)
-- Dependencies: 203
-- Data for Name: purchase; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2848 (class 0 OID 24699)
-- Dependencies: 205
-- Data for Name: purchasee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.purchasee VALUES (1, '2018-08-12', 3, 2, 4, 10, 230000);
INSERT INTO public.purchasee VALUES (2, '2018-07-12', 1, 1, 3, 1, 15000);
INSERT INTO public.purchasee VALUES (4, '2018-08-14', 4, 4, 7, 2, 100000);
INSERT INTO public.purchasee VALUES (3, '2018-01-01', 1, 1, 4, 3, 69000);
INSERT INTO public.purchasee VALUES (5, '2018-08-04', 2, 1, 6, 1, 10000);


--
-- TOC entry 2844 (class 0 OID 24663)
-- Dependencies: 201
-- Data for Name: shop; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.shop VALUES (1, 'Pishi-chitai', 'Sormovskiy', 10);
INSERT INTO public.shop VALUES (3, 'Dirigabl', 'Sormovskiy', 15);
INSERT INTO public.shop VALUES (4, 'The Best Books', 'Nizhegorodskiy', 8);
INSERT INTO public.shop VALUES (2, 'World of books', 'Autozavodskiy', 3);


--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 196
-- Name: book_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.book_id_seq', 7, true);


--
-- TOC entry 2863 (class 0 OID 0)
-- Dependencies: 198
-- Name: customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_id_seq', 5, true);


--
-- TOC entry 2864 (class 0 OID 0)
-- Dependencies: 202
-- Name: purchase_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.purchase_id_seq', 1, false);


--
-- TOC entry 2865 (class 0 OID 0)
-- Dependencies: 204
-- Name: purchasee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.purchasee_id_seq', 2, true);


--
-- TOC entry 2866 (class 0 OID 0)
-- Dependencies: 200
-- Name: shop_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.shop_id_seq', 4, true);


--
-- TOC entry 2703 (class 2606 OID 24649)
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (id);


--
-- TOC entry 2705 (class 2606 OID 24660)
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);


--
-- TOC entry 2709 (class 2606 OID 24679)
-- Name: purchase purchase_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_pkey PRIMARY KEY (id);


--
-- TOC entry 2711 (class 2606 OID 24704)
-- Name: purchasee purchasee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchasee
    ADD CONSTRAINT purchasee_pkey PRIMARY KEY (id);


--
-- TOC entry 2707 (class 2606 OID 24671)
-- Name: shop shop_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.shop
    ADD CONSTRAINT shop_pkey PRIMARY KEY (id);


--
-- TOC entry 2714 (class 2606 OID 24690)
-- Name: purchase purchase_book_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_book_fkey FOREIGN KEY (book) REFERENCES public.book(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2713 (class 2606 OID 24685)
-- Name: purchase purchase_customer_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_customer_fkey FOREIGN KEY (customer) REFERENCES public.customer(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2712 (class 2606 OID 24680)
-- Name: purchase purchase_shop_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_shop_fkey FOREIGN KEY (shop) REFERENCES public.shop(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2717 (class 2606 OID 24715)
-- Name: purchasee purchasee_book_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchasee
    ADD CONSTRAINT purchasee_book_fkey FOREIGN KEY (book) REFERENCES public.book(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2716 (class 2606 OID 24710)
-- Name: purchasee purchasee_customer_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchasee
    ADD CONSTRAINT purchasee_customer_fkey FOREIGN KEY (customer) REFERENCES public.customer(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 2715 (class 2606 OID 24705)
-- Name: purchasee purchasee_shop_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.purchasee
    ADD CONSTRAINT purchasee_shop_fkey FOREIGN KEY (shop) REFERENCES public.shop(id) ON UPDATE CASCADE ON DELETE RESTRICT;


-- Completed on 2019-05-13 17:36:17

--
-- PostgreSQL database dump complete
--

