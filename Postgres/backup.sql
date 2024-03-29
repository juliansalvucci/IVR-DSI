toc.dat                                                                                             0000600 0004000 0002000 00000045177 14442220605 0014454 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP           
                {            IVR    15.3    15.3 C    G           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         H           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false         I           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false         J           1262    16712    IVR    DATABASE     |   CREATE DATABASE "IVR" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Argentina.1252';
    DROP DATABASE "IVR";
                postgres    false         �            1259    16738    cambioestado    TABLE     �   CREATE TABLE public.cambioestado (
    id bigint NOT NULL,
    fechahorafin timestamp without time zone,
    fechahorainicio timestamp without time zone,
    estado_id bigint,
    llamada_id bigint
);
     DROP TABLE public.cambioestado;
       public         heap    postgres    false         �            1259    16737    cambioestado_id_seq    SEQUENCE     |   CREATE SEQUENCE public.cambioestado_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.cambioestado_id_seq;
       public          postgres    false    215         K           0    0    cambioestado_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.cambioestado_id_seq OWNED BY public.cambioestado.id;
          public          postgres    false    214         �            1259    16745    cliente    TABLE     �   CREATE TABLE public.cliente (
    id bigint NOT NULL,
    dni character varying(255),
    nombrecompleto character varying(255),
    nrocelular character varying(255)
);
    DROP TABLE public.cliente;
       public         heap    postgres    false         �            1259    16744    cliente_id_seq    SEQUENCE     w   CREATE SEQUENCE public.cliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cliente_id_seq;
       public          postgres    false    217         L           0    0    cliente_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;
          public          postgres    false    216         �            1259    16754    encuesta    TABLE     �   CREATE TABLE public.encuesta (
    id bigint NOT NULL,
    descripcion character varying(255),
    fechaencuesta character varying(255)
);
    DROP TABLE public.encuesta;
       public         heap    postgres    false         �            1259    16753    encuesta_id_seq    SEQUENCE     x   CREATE SEQUENCE public.encuesta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.encuesta_id_seq;
       public          postgres    false    219         M           0    0    encuesta_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.encuesta_id_seq OWNED BY public.encuesta.id;
          public          postgres    false    218         �            1259    16763    estado    TABLE     Z   CREATE TABLE public.estado (
    id bigint NOT NULL,
    nombre character varying(255)
);
    DROP TABLE public.estado;
       public         heap    postgres    false         �            1259    16762    estado_id_seq    SEQUENCE     v   CREATE SEQUENCE public.estado_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.estado_id_seq;
       public          postgres    false    221         N           0    0    estado_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.estado_id_seq OWNED BY public.estado.id;
          public          postgres    false    220         �            1259    16770    llamada    TABLE     t   CREATE TABLE public.llamada (
    id bigint NOT NULL,
    duracion character varying(255),
    cliente_id bigint
);
    DROP TABLE public.llamada;
       public         heap    postgres    false         �            1259    16769    llamada_id_seq    SEQUENCE     w   CREATE SEQUENCE public.llamada_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.llamada_id_seq;
       public          postgres    false    223         O           0    0    llamada_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.llamada_id_seq OWNED BY public.llamada.id;
          public          postgres    false    222         �            1259    16777    pregunta    TABLE     �   CREATE TABLE public.pregunta (
    id bigint NOT NULL,
    descripcion character varying(255),
    pregunta character varying(255),
    encuesta_id bigint
);
    DROP TABLE public.pregunta;
       public         heap    postgres    false         �            1259    16776    pregunta_id_seq    SEQUENCE     x   CREATE SEQUENCE public.pregunta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.pregunta_id_seq;
       public          postgres    false    225         P           0    0    pregunta_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.pregunta_id_seq OWNED BY public.pregunta.id;
          public          postgres    false    224         �            1259    16786    respuestadecliente    TABLE     �   CREATE TABLE public.respuestadecliente (
    id bigint NOT NULL,
    descripcion character varying(255),
    fechaencuesta character varying(255),
    llamada_id bigint,
    respuestaposible_id bigint
);
 &   DROP TABLE public.respuestadecliente;
       public         heap    postgres    false         �            1259    16785    respuestadecliente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.respuestadecliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.respuestadecliente_id_seq;
       public          postgres    false    227         Q           0    0    respuestadecliente_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.respuestadecliente_id_seq OWNED BY public.respuestadecliente.id;
          public          postgres    false    226         �            1259    16795    respuestaposible    TABLE     �   CREATE TABLE public.respuestaposible (
    id bigint NOT NULL,
    descripcion character varying(255),
    valor character varying(255),
    pregunta_id bigint
);
 $   DROP TABLE public.respuestaposible;
       public         heap    postgres    false         �            1259    16794    respuestaposible_id_seq    SEQUENCE     �   CREATE SEQUENCE public.respuestaposible_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.respuestaposible_id_seq;
       public          postgres    false    229         R           0    0    respuestaposible_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.respuestaposible_id_seq OWNED BY public.respuestaposible.id;
          public          postgres    false    228         �           2604    16741    cambioestado id    DEFAULT     r   ALTER TABLE ONLY public.cambioestado ALTER COLUMN id SET DEFAULT nextval('public.cambioestado_id_seq'::regclass);
 >   ALTER TABLE public.cambioestado ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214    215         �           2604    16748 
   cliente id    DEFAULT     h   ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);
 9   ALTER TABLE public.cliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217         �           2604    16757    encuesta id    DEFAULT     j   ALTER TABLE ONLY public.encuesta ALTER COLUMN id SET DEFAULT nextval('public.encuesta_id_seq'::regclass);
 :   ALTER TABLE public.encuesta ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    218    219         �           2604    16766 	   estado id    DEFAULT     f   ALTER TABLE ONLY public.estado ALTER COLUMN id SET DEFAULT nextval('public.estado_id_seq'::regclass);
 8   ALTER TABLE public.estado ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    220    221         �           2604    16773 
   llamada id    DEFAULT     h   ALTER TABLE ONLY public.llamada ALTER COLUMN id SET DEFAULT nextval('public.llamada_id_seq'::regclass);
 9   ALTER TABLE public.llamada ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    223    222    223         �           2604    16780    pregunta id    DEFAULT     j   ALTER TABLE ONLY public.pregunta ALTER COLUMN id SET DEFAULT nextval('public.pregunta_id_seq'::regclass);
 :   ALTER TABLE public.pregunta ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    225    225         �           2604    16789    respuestadecliente id    DEFAULT     ~   ALTER TABLE ONLY public.respuestadecliente ALTER COLUMN id SET DEFAULT nextval('public.respuestadecliente_id_seq'::regclass);
 D   ALTER TABLE public.respuestadecliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    227    226    227         �           2604    16798    respuestaposible id    DEFAULT     z   ALTER TABLE ONLY public.respuestaposible ALTER COLUMN id SET DEFAULT nextval('public.respuestaposible_id_seq'::regclass);
 B   ALTER TABLE public.respuestaposible ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    228    229    229         6          0    16738    cambioestado 
   TABLE DATA           `   COPY public.cambioestado (id, fechahorafin, fechahorainicio, estado_id, llamada_id) FROM stdin;
    public          postgres    false    215       3382.dat 8          0    16745    cliente 
   TABLE DATA           F   COPY public.cliente (id, dni, nombrecompleto, nrocelular) FROM stdin;
    public          postgres    false    217       3384.dat :          0    16754    encuesta 
   TABLE DATA           B   COPY public.encuesta (id, descripcion, fechaencuesta) FROM stdin;
    public          postgres    false    219       3386.dat <          0    16763    estado 
   TABLE DATA           ,   COPY public.estado (id, nombre) FROM stdin;
    public          postgres    false    221       3388.dat >          0    16770    llamada 
   TABLE DATA           ;   COPY public.llamada (id, duracion, cliente_id) FROM stdin;
    public          postgres    false    223       3390.dat @          0    16777    pregunta 
   TABLE DATA           J   COPY public.pregunta (id, descripcion, pregunta, encuesta_id) FROM stdin;
    public          postgres    false    225       3392.dat B          0    16786    respuestadecliente 
   TABLE DATA           m   COPY public.respuestadecliente (id, descripcion, fechaencuesta, llamada_id, respuestaposible_id) FROM stdin;
    public          postgres    false    227       3394.dat D          0    16795    respuestaposible 
   TABLE DATA           O   COPY public.respuestaposible (id, descripcion, valor, pregunta_id) FROM stdin;
    public          postgres    false    229       3396.dat S           0    0    cambioestado_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.cambioestado_id_seq', 1, false);
          public          postgres    false    214         T           0    0    cliente_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.cliente_id_seq', 1, false);
          public          postgres    false    216         U           0    0    encuesta_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.encuesta_id_seq', 1, false);
          public          postgres    false    218         V           0    0    estado_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.estado_id_seq', 1, false);
          public          postgres    false    220         W           0    0    llamada_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.llamada_id_seq', 1, false);
          public          postgres    false    222         X           0    0    pregunta_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.pregunta_id_seq', 1, false);
          public          postgres    false    224         Y           0    0    respuestadecliente_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.respuestadecliente_id_seq', 1, false);
          public          postgres    false    226         Z           0    0    respuestaposible_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.respuestaposible_id_seq', 1, false);
          public          postgres    false    228         �           2606    16743    cambioestado cambioestado_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.cambioestado
    ADD CONSTRAINT cambioestado_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.cambioestado DROP CONSTRAINT cambioestado_pkey;
       public            postgres    false    215         �           2606    16752    cliente cliente_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    217         �           2606    16761    encuesta encuesta_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.encuesta
    ADD CONSTRAINT encuesta_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.encuesta DROP CONSTRAINT encuesta_pkey;
       public            postgres    false    219         �           2606    16768    estado estado_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.estado
    ADD CONSTRAINT estado_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.estado DROP CONSTRAINT estado_pkey;
       public            postgres    false    221         �           2606    16775    llamada llamada_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.llamada
    ADD CONSTRAINT llamada_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.llamada DROP CONSTRAINT llamada_pkey;
       public            postgres    false    223         �           2606    16784    pregunta pregunta_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.pregunta
    ADD CONSTRAINT pregunta_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.pregunta DROP CONSTRAINT pregunta_pkey;
       public            postgres    false    225         �           2606    16793 *   respuestadecliente respuestadecliente_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.respuestadecliente
    ADD CONSTRAINT respuestadecliente_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.respuestadecliente DROP CONSTRAINT respuestadecliente_pkey;
       public            postgres    false    227         �           2606    16802 &   respuestaposible respuestaposible_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.respuestaposible
    ADD CONSTRAINT respuestaposible_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.respuestaposible DROP CONSTRAINT respuestaposible_pkey;
       public            postgres    false    229         �           2606    16813 #   llamada fk12gef4kdfdbb2mxby5svfehmi    FK CONSTRAINT     �   ALTER TABLE ONLY public.llamada
    ADD CONSTRAINT fk12gef4kdfdbb2mxby5svfehmi FOREIGN KEY (cliente_id) REFERENCES public.cliente(id);
 M   ALTER TABLE ONLY public.llamada DROP CONSTRAINT fk12gef4kdfdbb2mxby5svfehmi;
       public          postgres    false    223    3219    217         �           2606    16823 .   respuestadecliente fk2numxcahqs7jkg3wr6ic2byny    FK CONSTRAINT     �   ALTER TABLE ONLY public.respuestadecliente
    ADD CONSTRAINT fk2numxcahqs7jkg3wr6ic2byny FOREIGN KEY (llamada_id) REFERENCES public.llamada(id);
 X   ALTER TABLE ONLY public.respuestadecliente DROP CONSTRAINT fk2numxcahqs7jkg3wr6ic2byny;
       public          postgres    false    223    227    3225         �           2606    16803 (   cambioestado fk6wufo4upmsvwkhd8unkjokj93    FK CONSTRAINT     �   ALTER TABLE ONLY public.cambioestado
    ADD CONSTRAINT fk6wufo4upmsvwkhd8unkjokj93 FOREIGN KEY (estado_id) REFERENCES public.estado(id);
 R   ALTER TABLE ONLY public.cambioestado DROP CONSTRAINT fk6wufo4upmsvwkhd8unkjokj93;
       public          postgres    false    221    215    3223         �           2606    16818 $   pregunta fk8n6d3hm6mrwjojn4cvibxda9v    FK CONSTRAINT     �   ALTER TABLE ONLY public.pregunta
    ADD CONSTRAINT fk8n6d3hm6mrwjojn4cvibxda9v FOREIGN KEY (encuesta_id) REFERENCES public.encuesta(id);
 N   ALTER TABLE ONLY public.pregunta DROP CONSTRAINT fk8n6d3hm6mrwjojn4cvibxda9v;
       public          postgres    false    3221    225    219         �           2606    16808 (   cambioestado fkcp8vvfl1qm5o5jkde6dabokvk    FK CONSTRAINT     �   ALTER TABLE ONLY public.cambioestado
    ADD CONSTRAINT fkcp8vvfl1qm5o5jkde6dabokvk FOREIGN KEY (llamada_id) REFERENCES public.llamada(id);
 R   ALTER TABLE ONLY public.cambioestado DROP CONSTRAINT fkcp8vvfl1qm5o5jkde6dabokvk;
       public          postgres    false    3225    223    215         �           2606    16828 .   respuestadecliente fkfmb67pvb88frt8gx623y72m2w    FK CONSTRAINT     �   ALTER TABLE ONLY public.respuestadecliente
    ADD CONSTRAINT fkfmb67pvb88frt8gx623y72m2w FOREIGN KEY (respuestaposible_id) REFERENCES public.respuestaposible(id);
 X   ALTER TABLE ONLY public.respuestadecliente DROP CONSTRAINT fkfmb67pvb88frt8gx623y72m2w;
       public          postgres    false    227    229    3231         �           2606    16833 ,   respuestaposible fkrlnk152d72h1bepd9ili6vlkn    FK CONSTRAINT     �   ALTER TABLE ONLY public.respuestaposible
    ADD CONSTRAINT fkrlnk152d72h1bepd9ili6vlkn FOREIGN KEY (pregunta_id) REFERENCES public.pregunta(id);
 V   ALTER TABLE ONLY public.respuestaposible DROP CONSTRAINT fkrlnk152d72h1bepd9ili6vlkn;
       public          postgres    false    3227    229    225                                                                                                                                                                                                                                                                                                                                                                                                         3382.dat                                                                                            0000600 0004000 0002000 00000000005 14442220605 0014243 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3384.dat                                                                                            0000600 0004000 0002000 00000000005 14442220605 0014245 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3386.dat                                                                                            0000600 0004000 0002000 00000000005 14442220605 0014247 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3388.dat                                                                                            0000600 0004000 0002000 00000000005 14442220605 0014251 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3390.dat                                                                                            0000600 0004000 0002000 00000000005 14442220605 0014242 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3392.dat                                                                                            0000600 0004000 0002000 00000000005 14442220605 0014244 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3394.dat                                                                                            0000600 0004000 0002000 00000000005 14442220605 0014246 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3396.dat                                                                                            0000600 0004000 0002000 00000000005 14442220605 0014250 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           restore.sql                                                                                         0000600 0004000 0002000 00000035362 14442220605 0015374 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "IVR";
--
-- Name: IVR; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "IVR" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Argentina.1252';


ALTER DATABASE "IVR" OWNER TO postgres;

\connect "IVR"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: cambioestado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cambioestado (
    id bigint NOT NULL,
    fechahorafin timestamp without time zone,
    fechahorainicio timestamp without time zone,
    estado_id bigint,
    llamada_id bigint
);


ALTER TABLE public.cambioestado OWNER TO postgres;

--
-- Name: cambioestado_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cambioestado_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cambioestado_id_seq OWNER TO postgres;

--
-- Name: cambioestado_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cambioestado_id_seq OWNED BY public.cambioestado.id;


--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id bigint NOT NULL,
    dni character varying(255),
    nombrecompleto character varying(255),
    nrocelular character varying(255)
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- Name: cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_id_seq OWNER TO postgres;

--
-- Name: cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;


--
-- Name: encuesta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.encuesta (
    id bigint NOT NULL,
    descripcion character varying(255),
    fechaencuesta character varying(255)
);


ALTER TABLE public.encuesta OWNER TO postgres;

--
-- Name: encuesta_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.encuesta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.encuesta_id_seq OWNER TO postgres;

--
-- Name: encuesta_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.encuesta_id_seq OWNED BY public.encuesta.id;


--
-- Name: estado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estado (
    id bigint NOT NULL,
    nombre character varying(255)
);


ALTER TABLE public.estado OWNER TO postgres;

--
-- Name: estado_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estado_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estado_id_seq OWNER TO postgres;

--
-- Name: estado_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estado_id_seq OWNED BY public.estado.id;


--
-- Name: llamada; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.llamada (
    id bigint NOT NULL,
    duracion character varying(255),
    cliente_id bigint
);


ALTER TABLE public.llamada OWNER TO postgres;

--
-- Name: llamada_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.llamada_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.llamada_id_seq OWNER TO postgres;

--
-- Name: llamada_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.llamada_id_seq OWNED BY public.llamada.id;


--
-- Name: pregunta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pregunta (
    id bigint NOT NULL,
    descripcion character varying(255),
    pregunta character varying(255),
    encuesta_id bigint
);


ALTER TABLE public.pregunta OWNER TO postgres;

--
-- Name: pregunta_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pregunta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pregunta_id_seq OWNER TO postgres;

--
-- Name: pregunta_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pregunta_id_seq OWNED BY public.pregunta.id;


--
-- Name: respuestadecliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.respuestadecliente (
    id bigint NOT NULL,
    descripcion character varying(255),
    fechaencuesta character varying(255),
    llamada_id bigint,
    respuestaposible_id bigint
);


ALTER TABLE public.respuestadecliente OWNER TO postgres;

--
-- Name: respuestadecliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.respuestadecliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.respuestadecliente_id_seq OWNER TO postgres;

--
-- Name: respuestadecliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.respuestadecliente_id_seq OWNED BY public.respuestadecliente.id;


--
-- Name: respuestaposible; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.respuestaposible (
    id bigint NOT NULL,
    descripcion character varying(255),
    valor character varying(255),
    pregunta_id bigint
);


ALTER TABLE public.respuestaposible OWNER TO postgres;

--
-- Name: respuestaposible_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.respuestaposible_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.respuestaposible_id_seq OWNER TO postgres;

--
-- Name: respuestaposible_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.respuestaposible_id_seq OWNED BY public.respuestaposible.id;


--
-- Name: cambioestado id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cambioestado ALTER COLUMN id SET DEFAULT nextval('public.cambioestado_id_seq'::regclass);


--
-- Name: cliente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);


--
-- Name: encuesta id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encuesta ALTER COLUMN id SET DEFAULT nextval('public.encuesta_id_seq'::regclass);


--
-- Name: estado id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado ALTER COLUMN id SET DEFAULT nextval('public.estado_id_seq'::regclass);


--
-- Name: llamada id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.llamada ALTER COLUMN id SET DEFAULT nextval('public.llamada_id_seq'::regclass);


--
-- Name: pregunta id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pregunta ALTER COLUMN id SET DEFAULT nextval('public.pregunta_id_seq'::regclass);


--
-- Name: respuestadecliente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.respuestadecliente ALTER COLUMN id SET DEFAULT nextval('public.respuestadecliente_id_seq'::regclass);


--
-- Name: respuestaposible id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.respuestaposible ALTER COLUMN id SET DEFAULT nextval('public.respuestaposible_id_seq'::regclass);


--
-- Data for Name: cambioestado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cambioestado (id, fechahorafin, fechahorainicio, estado_id, llamada_id) FROM stdin;
\.
COPY public.cambioestado (id, fechahorafin, fechahorainicio, estado_id, llamada_id) FROM '$$PATH$$/3382.dat';

--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (id, dni, nombrecompleto, nrocelular) FROM stdin;
\.
COPY public.cliente (id, dni, nombrecompleto, nrocelular) FROM '$$PATH$$/3384.dat';

--
-- Data for Name: encuesta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.encuesta (id, descripcion, fechaencuesta) FROM stdin;
\.
COPY public.encuesta (id, descripcion, fechaencuesta) FROM '$$PATH$$/3386.dat';

--
-- Data for Name: estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estado (id, nombre) FROM stdin;
\.
COPY public.estado (id, nombre) FROM '$$PATH$$/3388.dat';

--
-- Data for Name: llamada; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.llamada (id, duracion, cliente_id) FROM stdin;
\.
COPY public.llamada (id, duracion, cliente_id) FROM '$$PATH$$/3390.dat';

--
-- Data for Name: pregunta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pregunta (id, descripcion, pregunta, encuesta_id) FROM stdin;
\.
COPY public.pregunta (id, descripcion, pregunta, encuesta_id) FROM '$$PATH$$/3392.dat';

--
-- Data for Name: respuestadecliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.respuestadecliente (id, descripcion, fechaencuesta, llamada_id, respuestaposible_id) FROM stdin;
\.
COPY public.respuestadecliente (id, descripcion, fechaencuesta, llamada_id, respuestaposible_id) FROM '$$PATH$$/3394.dat';

--
-- Data for Name: respuestaposible; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.respuestaposible (id, descripcion, valor, pregunta_id) FROM stdin;
\.
COPY public.respuestaposible (id, descripcion, valor, pregunta_id) FROM '$$PATH$$/3396.dat';

--
-- Name: cambioestado_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cambioestado_id_seq', 1, false);


--
-- Name: cliente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_id_seq', 1, false);


--
-- Name: encuesta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.encuesta_id_seq', 1, false);


--
-- Name: estado_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estado_id_seq', 1, false);


--
-- Name: llamada_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.llamada_id_seq', 1, false);


--
-- Name: pregunta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pregunta_id_seq', 1, false);


--
-- Name: respuestadecliente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.respuestadecliente_id_seq', 1, false);


--
-- Name: respuestaposible_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.respuestaposible_id_seq', 1, false);


--
-- Name: cambioestado cambioestado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cambioestado
    ADD CONSTRAINT cambioestado_pkey PRIMARY KEY (id);


--
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);


--
-- Name: encuesta encuesta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.encuesta
    ADD CONSTRAINT encuesta_pkey PRIMARY KEY (id);


--
-- Name: estado estado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado
    ADD CONSTRAINT estado_pkey PRIMARY KEY (id);


--
-- Name: llamada llamada_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.llamada
    ADD CONSTRAINT llamada_pkey PRIMARY KEY (id);


--
-- Name: pregunta pregunta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pregunta
    ADD CONSTRAINT pregunta_pkey PRIMARY KEY (id);


--
-- Name: respuestadecliente respuestadecliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.respuestadecliente
    ADD CONSTRAINT respuestadecliente_pkey PRIMARY KEY (id);


--
-- Name: respuestaposible respuestaposible_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.respuestaposible
    ADD CONSTRAINT respuestaposible_pkey PRIMARY KEY (id);


--
-- Name: llamada fk12gef4kdfdbb2mxby5svfehmi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.llamada
    ADD CONSTRAINT fk12gef4kdfdbb2mxby5svfehmi FOREIGN KEY (cliente_id) REFERENCES public.cliente(id);


--
-- Name: respuestadecliente fk2numxcahqs7jkg3wr6ic2byny; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.respuestadecliente
    ADD CONSTRAINT fk2numxcahqs7jkg3wr6ic2byny FOREIGN KEY (llamada_id) REFERENCES public.llamada(id);


--
-- Name: cambioestado fk6wufo4upmsvwkhd8unkjokj93; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cambioestado
    ADD CONSTRAINT fk6wufo4upmsvwkhd8unkjokj93 FOREIGN KEY (estado_id) REFERENCES public.estado(id);


--
-- Name: pregunta fk8n6d3hm6mrwjojn4cvibxda9v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pregunta
    ADD CONSTRAINT fk8n6d3hm6mrwjojn4cvibxda9v FOREIGN KEY (encuesta_id) REFERENCES public.encuesta(id);


--
-- Name: cambioestado fkcp8vvfl1qm5o5jkde6dabokvk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cambioestado
    ADD CONSTRAINT fkcp8vvfl1qm5o5jkde6dabokvk FOREIGN KEY (llamada_id) REFERENCES public.llamada(id);


--
-- Name: respuestadecliente fkfmb67pvb88frt8gx623y72m2w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.respuestadecliente
    ADD CONSTRAINT fkfmb67pvb88frt8gx623y72m2w FOREIGN KEY (respuestaposible_id) REFERENCES public.respuestaposible(id);


--
-- Name: respuestaposible fkrlnk152d72h1bepd9ili6vlkn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.respuestaposible
    ADD CONSTRAINT fkrlnk152d72h1bepd9ili6vlkn FOREIGN KEY (pregunta_id) REFERENCES public.pregunta(id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              