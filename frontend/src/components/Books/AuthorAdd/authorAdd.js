import React from 'react';
import {useHistory} from 'react-router-dom';

const AuthorAdd = (props) => {
    debugger;

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name: "",
        surname: "",
        countryId: 0  

    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        debugger;
        e.preventDefault();
        const countryId = formData.countryId;
        const name = formData.name;
        const surname = formData.surname;

        props.onAddAuthor(countryId,name, surname);
        history.push("/books");
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Author name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter author name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity">Author surname</label>
                        <input type="text"
                               className="form-control"
                               id="surname"
                               name="surname"
                               placeholder="Author surname"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Country</label>
                        <select name="countryId" className="form-control" onChange={handleChange}>
                            {props.countries.map((term) =>
                           
                                <option value={term.id}>{term.name}</option>
                            )}
                        </select>
                    </div>
         
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default AuthorAdd;