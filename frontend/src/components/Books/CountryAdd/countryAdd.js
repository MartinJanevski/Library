import React from 'react';
import {useHistory} from 'react-router-dom';

const CountryAdd = (props) => {
    debugger;

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name: "",
        continent: "",  

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
        const name = formData.name;
        const continent = formData.continent;

        props.onAddCountry(name,  continent);
        history.push("/books");
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Continent name</label>
                        <input type="text"
                               className="form-control"
                               id="continent"
                               name="continent"
                               required
                               placeholder="Enter continent name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="name">Country name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter country name"
                               onChange={handleChange}
                        />
                    </div>
         
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default CountryAdd;