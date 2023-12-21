toc.dat                                                                                             0000600 0004000 0002000 00000045177 14541147035 0014461 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP       !    -                {            IVR    15.3    15.3 C    G           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         H           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false         I           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false         J           1262    17042    IVR    DATABASE     |   CREATE DATABASE "IVR" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Argentina.1252';
    DROP DATABASE "IVR";
                postgres    false         �            1259    17044    cambioestado    TABLE     �   CREATE TABLE public.cambioestado (
    id bigint NOT NULL,
    fechahorafin timestamp without time zone,
    fechahorainicio timestamp without time zone,
    estado_id bigint,
    llamada_id bigint
);
     DROP TABLE public.cambioestado;
       public         heap    postgres    false         �            1259    17043    cambioestado_id_seq    SEQUENCE     |   CREATE SEQUENCE public.cambioestado_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.cambioestado_id_seq;
       public          postgres    false    215         K           0    0    cambioestado_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.cambioestado_id_seq OWNED BY public.cambioestado.id;
          public          postgres    false    214         �            1259    17051    cliente    TABLE     �   CREATE TABLE public.cliente (
    id bigint NOT NULL,
    dni character varying(255),
    nombrecompleto character varying(255),
    nrocelular character varying(255)
);
    DROP TABLE public.cliente;
       public         heap    postgres    false         �            1259    17050    cliente_id_seq    SEQUENCE     w   CREATE SEQUENCE public.cliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cliente_id_seq;
       public          postgres    false    217         L           0    0    cliente_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;
          public          postgres    false    216         �            1259    17060    encuesta    TABLE     �   CREATE TABLE public.encuesta (
    id bigint NOT NULL,
    descripcion character varying(255),
    fechaencuesta character varying(255)
);
    DROP TABLE public.encuesta;
       public         heap    postgres    false         �            1259    17059    encuesta_id_seq    SEQUENCE     x   CREATE SEQUENCE public.encuesta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.encuesta_id_seq;
       public          postgres    false    219         M           0    0    encuesta_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.encuesta_id_seq OWNED BY public.encuesta.id;
          public          postgres    false    218         �            1259    17069    estado    TABLE     Z   CREATE TABLE public.estado (
    id bigint NOT NULL,
    nombre character varying(255)
);
    DROP TABLE public.estado;
       public         heap    postgres    false         �            1259    17068    estado_id_seq    SEQUENCE     v   CREATE SEQUENCE public.estado_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.estado_id_seq;
       public          postgres    false    221         N           0    0    estado_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.estado_id_seq OWNED BY public.estado.id;
          public          postgres    false    220         �            1259    17076    llamada    TABLE     t   CREATE TABLE public.llamada (
    id bigint NOT NULL,
    duracion character varying(255),
    cliente_id bigint
);
    DROP TABLE public.llamada;
       public         heap    postgres    false         �            1259    17075    llamada_id_seq    SEQUENCE     w   CREATE SEQUENCE public.llamada_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.llamada_id_seq;
       public          postgres    false    223         O           0    0    llamada_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.llamada_id_seq OWNED BY public.llamada.id;
          public          postgres    false    222         �            1259    17083    pregunta    TABLE     �   CREATE TABLE public.pregunta (
    id bigint NOT NULL,
    descripcion character varying(255),
    pregunta character varying(255),
    encuesta_id bigint
);
    DROP TABLE public.pregunta;
       public         heap    postgres    false         �            1259    17082    pregunta_id_seq    SEQUENCE     x   CREATE SEQUENCE public.pregunta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.pregunta_id_seq;
       public          postgres    false    225         P           0    0    pregunta_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.pregunta_id_seq OWNED BY public.pregunta.id;
          public          postgres    false    224         �            1259    17092    respuestadecliente    TABLE     �   CREATE TABLE public.respuestadecliente (
    id bigint NOT NULL,
    descripcion character varying(255),
    fechaencuesta character varying(255),
    llamada_id bigint,
    respuestaposible_id bigint
);
 &   DROP TABLE public.respuestadecliente;
       public         heap    postgres    false         �            1259    17091    respuestadecliente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.respuestadecliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.respuestadecliente_id_seq;
       public          postgres    false    227         Q           0    0    respuestadecliente_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.respuestadecliente_id_seq OWNED BY public.respuestadecliente.id;
          public          postgres    false    226         �            1259    17101    respuestaposible    TABLE     �   CREATE TABLE public.respuestaposible (
    id bigint NOT NULL,
    descripcion character varying(255),
    valor character varying(255),
    pregunta_id bigint
);
 $   DROP TABLE public.respuestaposible;
       public         heap    postgres    false         �            1259    17100    respuestaposible_id_seq    SEQUENCE     �   CREATE SEQUENCE public.respuestaposible_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.respuestaposible_id_seq;
       public          postgres    false    229         R           0    0    respuestaposible_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.respuestaposible_id_seq OWNED BY public.respuestaposible.id;
          public          postgres    false    228         �           2604    17047    cambioestado id    DEFAULT     r   ALTER TABLE ONLY public.cambioestado ALTER COLUMN id SET DEFAULT nextval('public.cambioestado_id_seq'::regclass);
 >   ALTER TABLE public.cambioestado ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214    215         �           2604    17054 
   cliente id    DEFAULT     h   ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);
 9   ALTER TABLE public.cliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    216    217         �           2604    17063    encuesta id    DEFAULT     j   ALTER TABLE ONLY public.encuesta ALTER COLUMN id SET DEFAULT nextval('public.encuesta_id_seq'::regclass);
 :   ALTER TABLE public.encuesta ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    218    219         �           2604    17072 	   estado id    DEFAULT     f   ALTER TABLE ONLY public.estado ALTER COLUMN id SET DEFAULT nextval('public.estado_id_seq'::regclass);
 8   ALTER TABLE public.estado ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    220    221         �           2604    17079 
   llamada id    DEFAULT     h   ALTER TABLE ONLY public.llamada ALTER COLUMN id SET DEFAULT nextval('public.llamada_id_seq'::regclass);
 9   ALTER TABLE public.llamada ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    223    223         �           2604    17086    pregunta id    DEFAULT     j   ALTER TABLE ONLY public.pregunta ALTER COLUMN id SET DEFAULT nextval('public.pregunta_id_seq'::regclass);
 :   ALTER TABLE public.pregunta ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    225    224    225         �           2604    17095    respuestadecliente id    DEFAULT     ~   ALTER TABLE ONLY public.respuestadecliente ALTER COLUMN id SET DEFAULT nextval('public.respuestadecliente_id_seq'::regclass);
 D   ALTER TABLE public.respuestadecliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    227    226    227         �           2604    17104    respuestaposible id    DEFAULT     z   ALTER TABLE ONLY public.respuestaposible ALTER COLUMN id SET DEFAULT nextval('public.respuestaposible_id_seq'::regclass);
 B   ALTER TABLE public.respuestaposible ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    229    228    229         6          0    17044    cambioestado 
   TABLE DATA           `   COPY public.cambioestado (id, fechahorafin, fechahorainicio, estado_id, llamada_id) FROM stdin;
    public          postgres    false    215       3382.dat 8          0    17051    cliente 
   TABLE DATA           F   COPY public.cliente (id, dni, nombrecompleto, nrocelular) FROM stdin;
    public          postgres    false    217       3384.dat :          0    17060    encuesta 
   TABLE DATA           B   COPY public.encuesta (id, descripcion, fechaencuesta) FROM stdin;
    public          postgres    false    219       3386.dat <          0    17069    estado 
   TABLE DATA           ,   COPY public.estado (id, nombre) FROM stdin;
    public          postgres    false    221       3388.dat >          0    17076    llamada 
   TABLE DATA           ;   COPY public.llamada (id, duracion, cliente_id) FROM stdin;
    public          postgres    false    223       3390.dat @          0    17083    pregunta 
   TABLE DATA           J   COPY public.pregunta (id, descripcion, pregunta, encuesta_id) FROM stdin;
    public          postgres    false    225       3392.dat B          0    17092    respuestadecliente 
   TABLE DATA           m   COPY public.respuestadecliente (id, descripcion, fechaencuesta, llamada_id, respuestaposible_id) FROM stdin;
    public          postgres    false    227       3394.dat D          0    17101    respuestaposible 
   TABLE DATA           O   COPY public.respuestaposible (id, descripcion, valor, pregunta_id) FROM stdin;
    public          postgres    false    229       3396.dat S           0    0    cambioestado_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.cambioestado_id_seq', 1, false);
          public          postgres    false    214         T           0    0    cliente_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.cliente_id_seq', 1, false);
          public          postgres    false    216         U           0    0    encuesta_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.encuesta_id_seq', 1, false);
          public          postgres    false    218         V           0    0    estado_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.estado_id_seq', 1, false);
          public          postgres    false    220         W           0    0    llamada_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.llamada_id_seq', 1, false);
          public          postgres    false    222         X           0    0    pregunta_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.pregunta_id_seq', 1, false);
          public          postgres    false    224         Y           0    0    respuestadecliente_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.respuestadecliente_id_seq', 1, false);
          public          postgres    false    226         Z           0    0    respuestaposible_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.respuestaposible_id_seq', 1, false);
          public          postgres    false    228         �           2606    17049    cambioestado cambioestado_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.cambioestado
    ADD CONSTRAINT cambioestado_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.cambioestado DROP CONSTRAINT cambioestado_pkey;
       public            postgres    false    215         �           2606    17058    cliente cliente_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    217         �           2606    17067    encuesta encuesta_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.encuesta
    ADD CONSTRAINT encuesta_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.encuesta DROP CONSTRAINT encuesta_pkey;
       public            postgres    false    219         �           2606    17074    estado estado_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.estado
    ADD CONSTRAINT estado_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.estado DROP CONSTRAINT estado_pkey;
       public            postgres    false    221         �           2606    17081    llamada llamada_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.llamada
    ADD CONSTRAINT llamada_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.llamada DROP CONSTRAINT llamada_pkey;
       public            postgres    false    223         �           2606    17090    pregunta pregunta_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.pregunta
    ADD CONSTRAINT pregunta_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.pregunta DROP CONSTRAINT pregunta_pkey;
       public            postgres    false    225         �           2606    17099 *   respuestadecliente respuestadecliente_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.respuestadecliente
    ADD CONSTRAINT respuestadecliente_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.respuestadecliente DROP CONSTRAINT respuestadecliente_pkey;
       public            postgres    false    227         �           2606    17108 &   respuestaposible respuestaposible_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.respuestaposible
    ADD CONSTRAINT respuestaposible_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.respuestaposible DROP CONSTRAINT respuestaposible_pkey;
       public            postgres    false    229         �           2606    17119 #   llamada fk12gef4kdfdbb2mxby5svfehmi    FK CONSTRAINT     �   ALTER TABLE ONLY public.llamada
    ADD CONSTRAINT fk12gef4kdfdbb2mxby5svfehmi FOREIGN KEY (cliente_id) REFERENCES public.cliente(id);
 M   ALTER TABLE ONLY public.llamada DROP CONSTRAINT fk12gef4kdfdbb2mxby5svfehmi;
       public          postgres    false    3219    217    223         �           2606    17129 .   respuestadecliente fk2numxcahqs7jkg3wr6ic2byny    FK CONSTRAINT     �   ALTER TABLE ONLY public.respuestadecliente
    ADD CONSTRAINT fk2numxcahqs7jkg3wr6ic2byny FOREIGN KEY (llamada_id) REFERENCES public.llamada(id);
 X   ALTER TABLE ONLY public.respuestadecliente DROP CONSTRAINT fk2numxcahqs7jkg3wr6ic2byny;
       public          postgres    false    3225    223    227         �           2606    17109 (   cambioestado fk6wufo4upmsvwkhd8unkjokj93    FK CONSTRAINT     �   ALTER TABLE ONLY public.cambioestado
    ADD CONSTRAINT fk6wufo4upmsvwkhd8unkjokj93 FOREIGN KEY (estado_id) REFERENCES public.estado(id);
 R   ALTER TABLE ONLY public.cambioestado DROP CONSTRAINT fk6wufo4upmsvwkhd8unkjokj93;
       public          postgres    false    221    3223    215         �           2606    17124 $   pregunta fk8n6d3hm6mrwjojn4cvibxda9v    FK CONSTRAINT     �   ALTER TABLE ONLY public.pregunta
    ADD CONSTRAINT fk8n6d3hm6mrwjojn4cvibxda9v FOREIGN KEY (encuesta_id) REFERENCES public.encuesta(id);
 N   ALTER TABLE ONLY public.pregunta DROP CONSTRAINT fk8n6d3hm6mrwjojn4cvibxda9v;
       public          postgres    false    3221    219    225         �           2606    17114 (   cambioestado fkcp8vvfl1qm5o5jkde6dabokvk    FK CONSTRAINT     �   ALTER TABLE ONLY public.cambioestado
    ADD CONSTRAINT fkcp8vvfl1qm5o5jkde6dabokvk FOREIGN KEY (llamada_id) REFERENCES public.llamada(id);
 R   ALTER TABLE ONLY public.cambioestado DROP CONSTRAINT fkcp8vvfl1qm5o5jkde6dabokvk;
       public          postgres    false    215    223    3225         �           2606    17134 .   respuestadecliente fkfmb67pvb88frt8gx623y72m2w    FK CONSTRAINT     �   ALTER TABLE ONLY public.respuestadecliente
    ADD CONSTRAINT fkfmb67pvb88frt8gx623y72m2w FOREIGN KEY (respuestaposible_id) REFERENCES public.respuestaposible(id);
 X   ALTER TABLE ONLY public.respuestadecliente DROP CONSTRAINT fkfmb67pvb88frt8gx623y72m2w;
       public          postgres    false    3231    229    227         �           2606    17139 ,   respuestaposible fkrlnk152d72h1bepd9ili6vlkn    FK CONSTRAINT     �   ALTER TABLE ONLY public.respuestaposible
    ADD CONSTRAINT fkrlnk152d72h1bepd9ili6vlkn FOREIGN KEY (pregunta_id) REFERENCES public.pregunta(id);
 V   ALTER TABLE ONLY public.respuestaposible DROP CONSTRAINT fkrlnk152d72h1bepd9ili6vlkn;
       public          postgres    false    3227    229    225                                                                                                                                                                                                                                                                                                                                                                                                         3382.dat                                                                                            0000600 0004000 0002000 00000001663 14541147035 0014263 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	2023-04-15 09:32:11	2023-04-23 16:13:59	3	1
2	2023-04-28 18:15:05	2023-04-30 10:25:34	5	2
3	2023-11-05 18:15:05	2023-11-05 10:25:34	7	3
4	2023-05-17 11:01:11	2023-05-20 17:49:22	5	4
5	2023-06-10 18:15:05	2023-06-10 10:25:34	4	5
6	2022-09-19 18:15:05	2022-09-19 10:25:34	4	6
7	2021-02-13 18:15:05	2021-02-13 10:25:34	4	7
8	2020-06-25 18:15:05	2020-06-25 10:25:34	7	8
9	2021-07-02 18:15:05	2021-07-02 10:25:34	5	9
10	2023-06-27 18:15:05	2023-06-27 10:25:34	4	10
11	2022-12-15 18:15:05	2022-12-15 10:25:34	4	11
12	2021-02-10 18:15:05	2021-02-10 10:25:34	7	12
13	2022-05-01 18:15:05	2022-05-01 10:25:34	7	13
14	2020-05-18 18:15:05	2020-05-18 10:25:34	5	14
15	2023-11-20 18:15:05	2023-11-20 10:25:34	5	15
16	2021-08-09 18:15:05	2021-08-09 10:25:34	5	16
17	2022-06-18 18:15:05	2022-06-18 10:25:34	7	17
18	2023-04-26 18:15:05	2023-04-26 10:25:34	7	18
19	2023-04-26 18:15:05	2023-04-26 10:25:34	5	19
20	2023-07-25 18:15:05	2023-07-25 10:25:34	4	20
\.


                                                                             3384.dat                                                                                            0000600 0004000 0002000 00000001342 14541147035 0014257 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	41606040	Juan Perez	3534138212
2	17045987	Maria Perelda	3533486889
3	25487963	Jose Terreno	3536567571
4	22487873	Joel Perez	3536568523
5	35489943	Claudia Pereyra	3533547522
6	33464933	Gloria Terreno	3546557577
7	15487641	Javier Baudino	3536587631
8	20487963	Ludmila Almada	3534569835
9	36497320	Bautista Conrrero	3516067901
10	41487960	Mariela Alloco	3538527588
11	29483961	Franco Merani	3516530599
12	25389960	Lucia Casabona	3533527819
13	42497103	Etel Venturi	3519547301
14	15487969	Vilma Serre	3536567573
15	35467034	Roman Cena	3533490118
16	29487936	Milagros Demichelis	3534768531
17	24489830	Mauro Pagnone	3536087811
18	33485963	Paula Oggero	3536564630
19	25487763	Elias Delabay	3536540581
20	17483990	Diana Torres	3534562577
\.


                                                                                                                                                                                                                                                                                              3386.dat                                                                                            0000600 0004000 0002000 00000000234 14541147035 0014260 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	satisfaccion del cliente	2019-06-25
2	satisfaccion de necesidades	2020-03-21
3	preferencia y recurrencia	2020-04-18
4	evaluar competencia	2023-05-15
\.


                                                                                                                                                                                                                                                                                                                                                                    3388.dat                                                                                            0000600 0004000 0002000 00000000202 14541147035 0014255 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	iniciada
2	cancelada
3	finalizada
4	en_curso
5	pendiente_escucha
6	escucha_con_observacion
7	escucha_correcta
8	descartada
\.


                                                                                                                                                                                                                                                                                                                                                                                              3390.dat                                                                                            0000600 0004000 0002000 00000000677 14541147035 0014266 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	00:03:40.0970003	1
2	00:01:02.1859923	2
3	00:05:55.9278501	3
4	00:04:15.9277501	4
5	00:01:59.0008027	5
6	00:02:30.7095021	6
7	00:10:32.2078210	7
8	00:06:11.1070342	8
9	00:03:53.2019332	9
10	00:04:27.9054552	10
11	00:07:07.0005446	11
12	00:06:45.0540899	12
13	00:04:44.0077021	13
14	00:02:59.1167976	14
15	00:01:30.9979211	15
16	00:03:22.0409176	16
17	00:03:41.7828320	17
18	00:20:11.0077000	18
19	00:11:32.7823004	19
20	00:05:00.0000000	20
\.


                                                                 3392.dat                                                                                            0000600 0004000 0002000 00000001152 14541147035 0014255 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	recomendacion empresa	¿Cuál es la probabilidad de que recomiendes nuestra empresa a tus allegados?	1
2	recomedacion prd/serv	¿Cuál es la probabilidad de que recomiendes nuestro producto/servicio a tus allegados?	1
3	satisfaccion prod/serv	¿Consideras que el producto satisface tus necesidades?	2
4	volver a adquirir prd/serv	¿Cuán probable es que vuelvas a adquirir este producto/servicio?	3
5	recibir informacion	¿Estás interesado en recibir nueva información sobre nuestros futuros productos?	3
6	competencia	Si piensas en productos o servicios similares, ¿cómo calificarías a nuestra empresa?	4
\.


                                                                                                                                                                                                                                                                                                                                                                                                                      3394.dat                                                                                            0000600 0004000 0002000 00000002216 14541147035 0014261 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	imagen empresa no necesita revision	2023-06-16	1	1
2	el prod/serv podria mejorar	2023-06-16	1	5
3	cliente no satisfecho con el prod/serv, podria mejorar	2023-05-09	2	15
4	prod/serv no necesita revision	2023-06-10	3	3
5	la informacion sobre prod/serv, anteriormente brindada al cliente fue excesiva	2023-06-10	3	16
6	imagen empresa no necesita revision	2023-11-05	4	1
7	el prod/serv podria mejorar	2023-11-05	4	2
8	imagen empresa no necesita revision	2020-09-29	5	7
9	el prod/serv podria mejorar	2020-09-29	5	11
10	imagen empresa no necesita revision	2022-09-19	6	1
11	el prod/serv podria mejorar	2022-09-19	6	2
12	imagen empresa no necesita revision	2021-02-13	7	7
13	el prod/serv podria mejorar	2021-02-13	7	2
14	cliente no satisfecho con el prod/serv, podria mejorar	2020-06-25	8	15
15	cliente no satisfecho con el prod/serv, podria mejorar	2021-07-02	9	15
16	cliente no satisfecho con el prod/serv, podria mejorar	2023-06-27	10	15
17	cliente no satisfecho con el prod/serv, podria mejorar	2022-12-15	11	15
18	cliente no satisfecho con el prod/serv, podria mejorar	2021-02-10	12	15
19	cliente no satisfecho con el prod/serv, podria mejorar	2022-05-01	13	15
\.


                                                                                                                                                                                                                                                                                                                                                                                  3396.dat                                                                                            0000600 0004000 0002000 00000001164 14541147035 0014264 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	satisfactorio	Muy probable	1
2	satisfactorio	Muy probable	2
3	satisfactorio	Muy probable	4
4	satisfactorio	Probable	1
5	satisfactorio	Probable	2
6	satisfactorio	Probable	4
7	no satisfactorio	Poco probable	1
8	no satisfactorio	Poco probable	2
9	no satisfactorio	Poco probable	4
10	no satisfactorio	Nada probable	1
11	no satisfactorio	Nada probable	2
12	no satisfactorio	Nada probable	4
13	satisfactorio	Si	3
14	satisfactorio	Si	5
15	no satisfactorio	No	3
16	no satisfactorio	No	5
17	no satisfactorio	Regular	3
18	no satisfactorio	Regular	5
19	no satisfactorio	Regular	6
20	satisfactorio	Buena	6
21	no satisfactorio	Mala	6
\.


                                                                                                                                                                                                                                                                                                                                                                                                            restore.sql                                                                                         0000600 0004000 0002000 00000035362 14541147035 0015401 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
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