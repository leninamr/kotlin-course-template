import java.time.Year

data class Book(val name: String, val author: Author, val genre: Genre, val year: Year)
data class Author(val firstName: String = "", val middleName: String = "", val lastName: String = "")
data class User(val firstName: String, val middleName: String, val lastName: String)


enum class Genre {
    Fantasy,
    ScienceFiction,
    Detective,
    Science,
    Drama,
    Comedy,
    Horror,
    Comics
}

sealed class Status {
    object Available : Status()
    data class UsedBy(val user: User) : Status()
    object ComingSoon : Status()
    object Restoration : Status()
}

interface LibraryService {

    fun findBooks(name: String = "", author: Author = Author(), year: Year? = null, genre: Genre? = null)

    fun getAllBooks(): List<Book>
    fun getAllAvailableBooks(): List<Book>

    fun getBookStatus(book: Book): Status
    fun getAllBookStatuses(): Map<Book, Status>

    fun setBookStatus(book: Book, status: Status)

    fun addBook(book: Book, status: Status = Status.Available)

    fun registerUser(firstName: String, middleName: String, lastName: String)
    fun unregisterUser(user: User)

    fun takeBook(user: User, book: Book)
    fun returnBook(book: Book)
}

class LibraryServiceImplement : LibraryService {
    //TODO ограничение в три кнги
    private val listOfUsers = mutableListOf<User>()
    private val mapOfBooks = mutableMapOf<Book, Status>()
    override fun findBooks(name: String, author: Author, year: Year?, genre: Genre?) {
        val result = mapOfBooks.filter {
            (name == "" || name == it.key.name) && (author == Author() || author == it.key.author) && (year == null || year == it.key.year) && (genre == null || genre == it.key.genre)
        }
    }

    override fun getAllBooks(): List<Book> {
        val listOfBooks = mutableListOf<Book>()
        mapOfBooks.forEach { (Book) ->
            listOfBooks.add(Book)
        }
        return listOfBooks
    }

    override fun getAllAvailableBooks(): List<Book> {
        val listOfBooks = mutableListOf<Book>()
        mapOfBooks.forEach { (Book, status) ->
            if (status == Status.Available)
                listOfBooks.add(Book)
        }
        return listOfBooks
    }
//TODO  проверки возможности выполнения в функциях и проверять целостность данных
    override fun getBookStatus(book: Book): Status {
        //TODO доделать
        //return mapOfBooks[Book]
    }

    override fun getAllBookStatuses(): Map<Book, Status> {

    }

    override fun setBookStatus(book: Book, status: Status) {

    }

    override fun addBook(book: Book, status: Status = Status.Available) {

    }

    override fun registerUser(firstName: String, middleName: String, lastName: String) {

    }

    override fun unregisterUser(user: User) {

    }

    override fun takeBook(user: User, book: Book) {

    }

    override fun returnBook(book: Book) {

    }
}
