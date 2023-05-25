document.body.addEventListener('submit', (e) => {
    e.preventDefault();
    const form = e.target;
    const formData = new FormData(form);
    const data = Object.fromEntries(formData);
    console.log(data);
    form.reset();

    let endpoint = form.action;

    if (data['id']) {
        endpoint = endpoint.replace('%7Bid%7D', data['id']);
        delete data['id'];
    }

    console.log('Endpoint: ' + endpoint);

    fetch(endpoint, {
        method: form.method,
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then((response) => {
        console.log('Endpoint success response');
        console.log(response);
    }).catch((error) => {
        console.error('Endpoint failure');
        console.error(error);
    });
});