
    function validateDate(input) {
        const value = input.value;
        const pattern = /^\d{4}-\d{2}-\d{2}$/;

        if (!pattern.test(value)) {
            input.setCustomValidity("Date format should be 'YYYY-MM-DD'.");
        } else {
            input.setCustomValidity("");
        }
    }