--INFORMATION
create table if not exists information
(
    id       bigint generated by default as identity
        constraint information_pkey
            primary key,
    filename varchar(255),
    type     varchar(255) not null,
    tag      varchar(255),
    text     varchar(999)
);

alter table information
    owner to postgres;

INSERT INTO public.information (filename, type, tag, text)
VALUES (null, 'POLYCLINIC_INFO', 'ИСТОРИЯ ПОЛИКЛИНИКИ', 'Поликлиника основана 15 февраля 1985 года. С момента основания до марта 2015 года руководил учреждением главный врач Пархейчук Светлана Дмитриевна.  С октября 2015 года поликлинику возглавляет Акиншева Ольга Николаевна.
 В период 2011 - 2014 гг.  в учреждении проведена модернизация и в настоящий момент это современное  медицинское учреждение здравоохранения, оказывающее  квалифицированную медицинскую помощь детскому населению. Его целью является проведение профилактических мероприятий, направленных на предупреждение, раннее выявление и снижение заболеваемости,  детской инвалидности и смертности.
В своей структуре поликлиника имеет следующие подразделения:
3 педиатрических, из них 1 отделение по оказанию медицинской помощи детям в организованных коллективах, стоматологическое отделение, отделение медицинской реабилитации, хирурго-травматологическое отделение, клинико-диагностическая   лаборатория.      '),
       (null, 'USEFUL_INFO', 'ПРАВИЛА БЕЗОПАСНОСТИ ПРИ СИЛЬНОМ ДОЖДЕ, ГРАДЕ', 'МЧС напоминает правила безопасности при сильном дожде, граде
ЧТО ДЕЛАТЬ дома:
следите за сообщениями по радио, телевидению, в интернете;
по возможности оставайтесь дома или на работе;
отключите электроприборы;
отойдите от окон;
поставьте машину в гараж.
ЧТО ДЕЛАТЬ в машине:
не пытайтесь преодолеть подтопленные участки;
медленно перестройтесь в крайний правый ряд (на обочину) и, не прибегая к экстренному торможению, прекратите движение;
включите аварийные огни и переждите ливень.
ЧТО ДЕЛАТЬ на улице:
спрячьтесь в здании;
если это невозможно, сумкой, одеждой, подручными средствами защитите голову.
Важно! Нельзя спускаться в подземные переходы.'),
       (null, 'NEWS', 'ПОЖАР', 'На юге Беларуси разбушевался торфяной пожар. Тушат уже больше 10 дней.'
           'На юге Беларуси желто-оранжевые клубы дыма — это горят торфяники в Петриковском районе. Их тушат уже больше 10 дней, но и сегодня все выглядит немного апокалиптично. Посмотрите, как борются человек и огонь.
По информации МЧС, площадь пожара стала меньше и составляет 40 гектаров. Сейчас там 94 человека и более чем два десятка единиц техники, сверху все контролирует беспилотник.'),
       (null, 'USEFUL_INFO', 'О ПОРЯДКЕ ИССЛЕДОВАНИЯ ИКСОДОВЫХ КЛЕЩЕЙ', 'Согласно «Алгоритму действий медицинских работников при обращении пациента по поводу укуса клеща», утвержденного приказом Министерства здравоохранения Республики Беларусь от 19.04.2016 г. №338 «О мероприятиях по профилактике заболеваний, передаваемых иксодовыми клещами»:

После укуса клеща необходимо обратиться к врачу (инфекционисту, терапевту, педиатру, хирургу) для назначения экстренной химиопрофилактики. Важно помнить, что максимальный профилактический эффект достигается только в том случае, если экстренная профилактика начата в первые 72 часа.
Исследование удаленного клеща показано только лицам, имеющим медицинские противопоказания к приему лекарственных средств. В этом случае медицинский работник выдает направление на бесплатное лабораторное исследование клеща.
В остальных случаях по желанию пациент имеет право самостоятельно обратиться в микробиологическую лабораторию для проведения исследования клеща на платной основе.'),
       (null, 'USEFUL_INFO', 'ИГРОМАНИЯ',
        'Игромания представляет собой патологическое пристрастие к различным играм (преимущественно азартным), развивающееся на уровне психологии, и проявляющееся нарушениями в эмоционально-волевой сфере. Игромания проявляется тем, что для человека игра становится доминирующей ценностью в жизни, вытесняя социальные, семейные, профессиональные и материальные ценности. Человек уделяет основное время и внимание игре, а ко всем остальным обязанностям относится по остаточному принципу. Поскольку игромания имеет хроническое течение, то ее главным признаком является неспособность человека сопротивляться импульсу к началу игры, вследствие чего больной вовлекается в эпизоды игры, несмотря на жизненные обстоятельства, что приводит к разрушению семейной жизни, проблемам на работе и в социуме.'),
       (null, 'POLYCLINIC_INFO', 'О РАБОТЕ ДОВРАЧЕБНОГО КАБИНЕТА',
        'Уважаемые посетители! С 01.10.2020 доврачебный кабинет (108) не будет работать. По вопросам прохождения проф. осмотров обращаться на проф.прием к участковой медицинской сестре. Для определения остроты зрения и цветоаномалии обращаться в 315 кабинет по чётным дням с 16:30-19:30, нечётным дням с 8:00-12:00.'),
       (null, 'POLYCLINIC_INFO', 'РЕЖИМ РАБОТЫ ЛАБОРАТОРИИ',
        'Изменяется режим работы клинико-диагностической лаборатории планового приема: 7.30.-9.00. здоровый прием по мед.профилактике; 9.00-11.00. лечебный прием с признаками инфекционных заболеваний. Остальное время работы и ВТОРНИК без изменений.'),
       (null, 'NEWS', 'О ПРОДЛЕНИИ СРОКА ДЕЙСТВИЯ ДОКУМЕНТОВ', '13 мая 2021 года издан Указ Президента Республики Беларусь № 187, которым продлевается срок действия справок и иных документов.
Указ направлен на снижение административной нагрузки на физических и юридических лиц в период реализации мероприятий по профилактике COVID-19. С учетом принимаемых в стране мер по минимизации распространения инфекции, вызванной COVID-19, многие граждане не имеют возможности обратиться за заменой необходимых документов по ряду причин (нахождение на самоизоляции, больничном, в отпуске, на даче и т.д.).')
;
