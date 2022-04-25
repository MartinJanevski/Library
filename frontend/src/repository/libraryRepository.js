import axios from '../custom-axios/axios';

const LibraryService = {
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchBooks: () => {
        return axios.get("/books");
    },

    fetchAuthors: () => {
        return axios.get("/authors");
    },
    fetchCountries: () => {
        return axios.get("/countries");
    },
    

    addCountry: (continet, name) => {
        return axios.post("/countries", {
            "continent": continet,
            "name" : name
        });
    },

    addAuthor: (countryId, name, surname) => {
        return axios.post("/authors", {
            "countryId": countryId,
            "name" : name,
            "surname": surname
        });
    },


    addBook: (authorId,  availableCopies, category,name) => {
        return axios.post("/books", {
            "authorId": authorId, "availableCopies": availableCopies,"category": category,"name": name
        });
    },
    
    

    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
 
    markAsTaken: (id) => {
        return axios.patch(`/books/${id}/rent`);
    },


    addProduct: (name, price, quantity, category, manufacturer) => {
        return axios.post("/products/add", {
            "name" : name,
            "price" : price,
            "quantity" : quantity,
            "category" : category,
            "manufacturer" : manufacturer
        });
    },
    editProduct: (id, name, price, quantity, category, manufacturer) => {
        return axios.put(`/products/edit/${id}`, {
            "name" : name,
            "price" : price,
            "quantity" : quantity,
            "category" : category,
            "manufacturer" : manufacturer
        });
    },
    getProduct: (id) => {
        return axios.get(`/products/${id}`);
    }

}




export default LibraryService;
