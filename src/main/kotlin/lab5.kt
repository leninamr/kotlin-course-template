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
    private val maxCountOfBooks = 3
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
    
    //TODO main
    override fun getBookStatus(book: Book): Status {
        if (!mapOfBooks.contains(book)) throw IllegalStateException("There's no such a book")
        return mapOfBooks[book]!!
    }

     override fun getAllBookStatuses(): Map<Book, Status> {
        return mapOfBooks
    }

    override fun setBookStatus(book: Book, status: Status) {
        if (!mapOfBooks.contains(book)) throw IllegalStateException("There's no such a book")
        mapOfBooks.replace(book, status)
    }

    override fun addBook(book: Book, status: Status) {
        if (mapOfBooks.contains(book)) throw IllegalStateException("There's already has this book")
        mapOfBooks[book] = status
    }

    override fun registerUser(firstName: String, middleName: String, lastName: String) {
        if (listOfUsers.contains(
                User(
                    firstName,
                    middleName,
                    lastName
                )
            )
        ) throw IllegalStateException("This user is already at list")
        listOfUsers.add(User(firstName, middleName, lastName))
    }

    override fun unregisterUser(user: User) {
        if (!listOfUsers.contains(user)) throw IllegalStateException("There's no such a user")
        listOfUsers.remove(user)

    }

    override fun takeBook(user: User, book: Book) {
        if (!mapOfBooks.contains(book)) throw IllegalStateException("There's no such a book")
        if (!listOfUsers.contains(user)) throw IllegalStateException("There's no such a user")
        if (mapOfBooks.values.count() {
                ((it as Status.UsedBy).user == user)
            } <= maxCountOfBooks
        )
            setBookStatus(book, Status.UsedBy(user))
        else throw IllegalStateException("The one user can have only $maxCountOfBooks books")
    }

    override fun returnBook(book: Book) {
        if (!mapOfBooks.contains(book)) throw IllegalStateException("There's no such a book")
        if (mapOfBooks[book] !is Status.UsedBy) throw IllegalStateException("This book is not taken")
        setBookStatus(book, Status.Available)
    }
}
