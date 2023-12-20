package com.example.slaider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
/*import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager*/
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: imageAdapter
    /*private lateinit var textContainer: text_container*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val itemList: RecyclerView = findViewById(R.id.viewPager2)
        val items = arrayListOf<Item>()

        items.add(Item(1, "book1", "Болезни уха, горла, носа. Современный взгляд на причины и лечение", "Григорий Константинович Леонов", 2023, "Медицина, Здоровье", "О причинах, диагностике и методах лечения самых распространенных заболеваний уха, горло и носа. Автор книги, Григорий Леонов, врач-оториноларинголог (ЛОР) с опытом работы более 10 лет. Он объясняет, как устроены ухо, горло и нос, какие симптомы сопровождают то или иное заболевание, связанное с ними, и какая терапия считается эффективной с точки зрения доказательной медицины. Из-за чего возникают риносинуситы и кровотечение из носа? О чем могут говорить частые ангины? Правда ли, что лучше не пользоваться ватными палочками? От травм носа до нарушений слуха, от симптоматики до препаратов – доктор Леонов разбирает самые разные темы, которые касаются здоровья уха, горла и носа."))
        items.add(Item(2,"book2", "Медицина в Средневековье", "Максим Сергеевич Томчин, Александр Бениаминович Томчин", 2023, "Медицина, Здоровье","Эта книга посвящена медицине Средневековья – загадочной, странной и удивительной.  Как в ту эпоху людям удавалось оградить себя от многих недугов, в том числе смертельно опасных, которые обрушивались на них? Как могла существовать медицина, если все науки были подчинены богословию? Мог ли врач проверять лекарства, не угодив на костер инквизиции? Известны ли нам средневековые рецепты? Можно ли верить существовавшим тогда лекарствам? Или мы умерли бы от них при первом же чихании? А выжили бы мы с вами, попав в руки хирурга, который не имел медицинского образования и оперировал без наркоза? Знал ли этот хирург анатомию? А если бы он взялся избавить нас от головной боли, просверлив отверстие в черепе? Выжили бы мы, если бы при эпидемии чумы по совету врача ели мясо гадюки и пили бульон из него же? Сколько бы мы прожили в таких условиях?\n" +
                "\n" +
                "Топталась ли средневековая медицина на месте или была источником полезных знаний? В наши дни люди опять становятся жертвами новых, незнакомых эпидемий. Возникает вопрос: не было ли у лекарей Средневековья утерянных рецептов, которые могли бы пригодиться сегодня? Отвечая на эти вопросы, книга дает наглядное представление об истории западноевропейской медицины. Откройте ее на любой странице – вы найдете любопытные исторические факты, а иногда и секреты средневековых целителей. Мы познакомимся с их рецептами на все случаи жизни – и как влюбить в себя, и как избавиться от того, кто вам надоедает. Книга рассчитана на широкий круг читателей: и на тех, кто интересуется или занимается медициной, и на тех, кто старается держаться от врачей подальше.\n"))
        items.add(Item(3, "book3", "Десерты, а еще торты, пирожные, кексы и печенье ", "Пьер-Луи Вьель, Валери Друэ", 2022, "Кулинария, Хобби и ремесла","Коллекция сладких рецептов для взыскательных сладкоежек: тирамису с бретонским печеньем и карамелью понравится ценителям итальянской классики, торт «Три шоколада» и шоколадно-апельсиновый кекс порадуют любителей шоколада, замороженная нуга с фисташками освежит в жаркий день, а эффектная пирамида из шу украсит праздничный стол – недаром французы предпочитают ее многоярусным тортам! Пирог-перевертыш с малиной, кофейный дакуаз, баскский пирог с черешней, апельсиновая ромовая баба, пирожное «Колодец любви», разноцветные мини-маффины, канеле, мадлен с лимоном, кофе и зеленым чаем, морковный кекс с грецкими орехами и шафраном, нежнейший тарт-татен… более 40 рецептов на любой вкус и случай! А еще авторы приготовили для вас рецепты соусов, кули, карамели и кремов, которые станут отличным дополнением к десерту."))
        items.add(Item(4, "book4", "Лёд моих диких снов", "Ника Каирами", 2022, "Драма", "Когда я убеждал себя в том, что мне нечего терять, я и помыслить не мог, что что-то всё-таки осталось. Большое и незримое, что не давало мне перешагнуть черту.\n" +
                "Человечность.\n" +
                "Это было она. Но сегодня я и её лишился.\n" +
                "Лишился подле того, кому она вовсе не была знакома.\n" +
                "Должно ли это меня успокоить?\n" +
                "Успокоить, когда за стенкой лежат двое моих друзей в \"черном тюльпане\", ещё утром ходившие по этой земле.\n" +
                "Война.\n" +
                "Я в полной мере осознал, что у этого слова был солоноватый привкус железа. И бешеная боль потери и безысходности. Понимание собственного бессилия, когда на\n" +
                "твоих глазах убивают невинных ребят. И лучшее, что ты можешь сделать — убить в ответ.\n"))
        items.add(Item(5, "book5", "Гори", "Анна Верещагина", 2021, "Современные любовные романы, Драма, Самиздат, сетевая литература", "Я самая обыкновенная студентка отчаянно влюбленная в своего куратора. Перспективного, ответственного, красавца с леденящими душу глазами, но проблема состоит в том, что у него есть девушка и мы знакомы с детства. Он считает меня близким ему человеком, но не настолько близким, чтобы держать за руку.\n" +
                "Чем сильнее я хочу заполучить его, тем чаще разочаровываюсь неудачам, но руки не опускаю и продолжаю идти к цели. Между нами определенно есть притяжение и он это знает.\n"))
        items.add(Item(6, "book6", "Море и жаворонок. Из европейских и американских поэтов XVI–XX вв.", "Коллектив авторов", 2019, "Классическая зарубежная поэзия", "Представительная антология пяти веков поэзии, в которую входят крупнейшие поэты Старого и Нового Света (Джон Донн, Джон Китс, Уильям Шекспир, Льюис Кэрролл, Уильям Йейтс, Эмили Дикинсон и другие), суммирует полувековую работу известного переводчика Григория Михайловича Кружкова.\n" +
                "Английские, американские, французские и испанские стихи даются в хронологическом порядке, выявляющем общие тенденции европейской поэзии. Начинается книга со своеобразного пролога: древнеирландских стихов раннего Средневековья – именно здесь впервые появилась рифмованная поэзия, вскоре распространившаяся по всему континенту.\n" +
                "Григорий Кружков – лауреат Государственной премии РФ, премии Гильдии переводчиков «Мастер», Большой Бунинской и Волошинской премий и др.; профессор, член Шекспировской комиссии РАН; почетный доктор литературы Дублинского университета.\n"))
        items.add(Item(7, "book7", "Взломать всё. Как сильные мира сего используют уязвимости систем в своих интересах", "Брюс Шнайер", 2023, "Программирование, программы, базы данных", "Классический образ хакера – это специалист ИТ высочайшего класса, который знает несколько языков программирования, разбирается в устройстве систем безопасности и в два счета подберет пароль к вашему почтовому ящику. Он изучает системы для того, чтобы найти в них уязвимости и заставить работать в своих интересах. Однако взламывать можно не только компьютеры, но и социальные системы: от налогового законодательства до финансовых рынков и политики.\n" +
                "В своей книге легендарный криптограф, специалист по кибербезопасности и преподаватель Гарварда Брюс Шнайер рассказывает о том, как могущественные, но неизвестные публике хакеры помогают богатым и влиятельным людям становиться еще богаче и манипулировать сознанием людей. Кроме того, он приводит огромное количество примеров хаков социальных систем: взломов тарифных планов для междугородних звонков, банкоматов, программ лояльности пассажиров, манипуляций на рынке элитной недвижимости и многих других. Прочитав ее, вы узнаете, как замечать взломы, и уже не сможете смотреть на мир по-прежнему.\n" +
                "Для кого\n" +
                "Для тех, кто хочет лучше понимать, как богатые и влиятельные люди меняют правила под себя и управляют общественным сознанием.\n"))
        items.add(Item(8, "book8", "Темные данные. Практическое руководство по принятию правильных решений в мире недостающих данных", "Дэвид Хэнд", 2021, "Программирование, программы, базы данных, Экономика", "Человечество научилось собирать, обрабатывать и использовать в науке, бизнесе и повседневной жизни огромные массивы данных. Но что делать с данными, которых у нас нет? Допустимо ли игнорировать то, чего мы не замечаем? Британский статистик Дэвид Хэнд считает, что это по меньшей мере недальновидно, а порой – крайне опасно. В своей книге он выделяет 15 влияющих на наши решения и действия видов данных, которые остаются в тени. Например, речь идет об учете сигналов бедствия, которые могли бы подать жители бедных районов, если бы у них были смартфоны, результатах медицинского исследования, которые намеренно утаили или случайно исказили, или данных, ставших «темными» из-за плохого набора критериев для включения в выборку. Хэнд также рассказывает о том, какие меры могут сгладить эффект «темных данных» и как их можно обратить себе на пользу. Книга будет интересна широкому кругу читателей, интересующихся дата-сайенс, программированием и статистикой."))
        items.add(Item(9, "book9", "Ребята Джо", "Луиза Мэй Олкотт", 2020, "Классическая проза", "Луиза Мэй Олкотт закончила свою знаменитую сагу о жизни семейства Марч в 1886 г. Именно тогда впервые была опубликована четвертая, заключительная часть ее тетралогии - «Ребята Джо». В ней уже прославленная к тому времени американская писательница со свойственным ей тонким юмором рассказывает о дальнейшей судьбе детей Джо, демонстрируя свой талант внимательного наблюдателя и знатока человеческих душ. Ее герои постепенно взрослеют, влюбляются, сталкиваются с самыми разными житейскими проблемами и успешно их преодолевают. История всех персонажей, которые впервые появляются в третьей книге известной писательницы - «Жизнь в Пламфильде с ребятами Джо», развивается порой совершенно непредсказуемо. После безусловного успеха своих полубиографических романов, Луиза Олкотт не оставляла перо до самой своей кончины в 1888 году. Помимо знаменитой тетралогии ее литературное наследие включает несколько новелл, а также десятки рассказов, включая истории для детей."))
        items.add(Item(10,  "book10", "Психология энергичных людей", "Эленика Лис", 2013, "Эзотерика, эзотерическая литература, Самосовершенствование, Язычество", "Люди часто жалуются на то, что им не хватает сил, куда-то деваются желания, и усталость настигает задолго до времени отхода ко сну. Неужели и правда у современного человека энергии меньше, чем у людей предыдущих поколений?\n" +
                "Оказывается, нет. Но мы совершаем множество ошибок в использовании своего энергетического ресурса и поэтому нам кажется, что силы уже в первой половине дня на исходе, а энтузиазм, азарт, радость жизни – явления эфемерные и кратковременные.\n" +
                "Давайте попробуем вернуть себе нечаянно потерянное. Для начала выясним, где мы энергию теряем. А потом посмотрим, из каких источников мы можем ее черпать. Жить станет легче, жить станет веселее. Жизнь – это энергия, которую мы можем использовать для счастья.\n"))


        itemList.layoutManager =LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        itemList.adapter = imageAdapter(items, this)*/

        init()
        setUpTransformer()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
            }
        })
    }

    override fun onPause() {
        super.onPause()

        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()

        handler.postDelayed(runnable, 2000)
    }

    private val runnable = Runnable{
        viewPager2.currentItem = viewPager2.currentItem   //Здесь при добавлении +-1 слайдер движется сам
    }

    private fun setUpTransformer(){                            //Модификация image container
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f

        }

        viewPager2.setPageTransformer(transformer)

    }
    
    private fun init(){
        viewPager2 = findViewById(R.id.viewPager2)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.book1)
        imageList.add(R.drawable.book2)
        imageList.add(R.drawable.book3)
        imageList.add(R.drawable.book4)
        imageList.add(R.drawable.book5)
        imageList.add(R.drawable.book6)
        imageList.add(R.drawable.book7)
        imageList.add(R.drawable.book8)
        imageList.add(R.drawable.book9)
        imageList.add(R.drawable.book10)


        adapter = imageAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }
}
//сможешь сделать так чтобы слайдер двигался только при касании