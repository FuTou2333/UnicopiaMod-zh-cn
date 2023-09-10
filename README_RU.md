# Unicopia

[![Downloads](https://img.shields.io/github/downloads/Sollace/Unicopia/total.svg?color=yellowgreen)](https://github.com/Sollace/Unicopia/releases/latest)
![](https://img.shields.io/badge/api-fabric-orange.svg)

[![en](https://img.shields.io/badge/lang-en-012169.svg)](README.md)

Привнесите магию дружбы в Minecraft!

То, что начиналось как скромная утилита, позволяющая сделать игру за единорога немного более увлекательной, 
переросло в полноценное преобразование в пони, который привносит в мир Minecraft новую магию, механику и опыт, 
чтобы вы действительно почувствовали себя в мире Эквестрии!

# Возможности

## Узнайте, каково это - играть за свою любимую расу пони!

Единороги, пегасы, земные пони и даже чейнджлинги имеют свои особые способности.
 
 - *Сыграйте за единорога* и научитесь пользоваться магией! Создайте свою первую книгу заклинаний и экспериментируйте, 
   изучая различные заклинания и их действие, или просто погрузитесь в историю, чтобы узнать больше о прошлом этого загадочного мира!

   Кроме заклинаний, единороги могут создавать щит, чтобы защитить себя, или пускать магические огненные снаряды, 
   чтобы испепелить врага. Единороги также могут телепортироваться, чтобы обойти препятствия или просто добраться до труднодоступных мест.

  - *Сыграйте за пегаса* и покорите небеса! Помимо умения летать, пегасы могут устраивать дождевые бури, 
    управлять погодой, засовывая её в банки, а также обладают большей дальностью полёта и скоростью, чем другие расы.
 
 - *Играйте за скромного фонового пони*! Земные пони более выносливы и тяжёлы, чем другие расы. 
   Они также обладают способностью пинать деревья, чтобы добыть пищу, а также могут ускорить рост урожая. Если вы земной пони, вы никогда не будете голодать.

 Хочется перейти на тёмную сторону?

 - *Станьте единым целым с ульем* и превращайтесь в кого угодно, играя за чейнджлинга. Охотьтесь и питайтесь любовью других игроков и мобов.
   Некоторые формы могут даже обладать своими уникальными способностями.
  
 - *Окунитесь в ночь* за бэтпони. Бэтпони обладают неограниченным количеством криков, видят в темноте и умеют летать!
   Единственный минус - нужно носить очень крутые солнцезащитные очки, иначе солнце будет жечь глаза. Я думаю, это справедливая цена, а вы?
  
### Управляйте своим рационом

  Игра за пони - это не только пинки и удары! Как у травоядных, у вас есть возможность питаться многими продуктами, 
  которые обычные игроки обычно не едят. Чувствуете голод? Попробуйте нарвать цветов на лугу, или сена! 
  Я слышал, что сенобургеры очень вкусные, если вы сможете найти немного овса.

### Понифицированные картины

  Ведь что это был бы за пони-мод, если бы в нём не было этого? У каждой расы есть хотя бы один рисунок, представляющий её, 
  так что покажите свою гордость и поднимите флаг!

  Дисклеймер: Радужных флагов нет (пока)

### Природные явления

  - Воздушный поток (плохо) влияет на пегасов, остерегайтесь летать во время грозы! Там может быть опасно!
    Если вы играете за летающий вид или просто любите приятные вещи, попробуйте построить метеорологическую жилу.
    Она показывает фактическое, абсолютно реальное, а не плохо смоделированное направление ветра в вашем мире Minecraft. Только учтите,
    что направление и сила ветра ситуативны (и плохи), и будут отличаться в зависимости от того, где вы находитесь и на какой высоте.

  - Горячий воздух поднимает
    Нет, это не плохой фильм про "Звездные войны", это реальная механика. Песок и лава придают летающим видам дополнительную подъёмную силу. 
    Вода - наоборот. Попробуйте! А вообще, не стоит, я не хочу чтобы вы утонули.

### Магические предметы и артефакты

  - Создайте и постройте святилище для Кристального сердца, чтобы оказать ценную поддержку своим друзьям.
  - Или раздайте браслеты товарищества своим друзьям не-единорогам, чтобы они могли приобщиться к вашей силе
    или просто посмеяться, когда вы телепортируетесь, а они оказываются рядом.
  - Отправляйте и получайте предметы с помощью свитка дыхания дракона.
  - Возможно, я ещё что-то забыл (скорее всего? УуУуУууУУуу... Жуткие секретные механики)

У вас есть отзывы к этому описанию?
Нашли проблемы или я что-то упустил? Напишите мне в Discord.
Всё продолжает меняться, поэтому данное описание может быть неактуальным.

# Как играть

Более подробная информация приведена в файле HOW_TO_PLAY_RU.md.

# Зависимости и сборка

### Только для 1.19.3

Этот проект использует reach-entity-attributes, который на момент написания статьи может быть не обновлён.
Если вы собираете проект для версии 1.19.3, вы можете выполнить следующие шаги, чтобы убедиться, что он доступен в git:

`git clone https://github.com/Sollace/reach-entity-attributes`
`cd reach-entity-attributes`
`gradlew build publishToMavenLocal`

### Сборка Unicopia

`git clone https://github.com/Sollace/Unicopia`
`cd Unicopia` 
`gradlew build`

После выполнения вышеуказанных команд собранные файлы будут находиться в каталоге /build/bin` в папке Unicopia.