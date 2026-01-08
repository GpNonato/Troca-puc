document.getElementById('editButton').addEventListener('click', function () {
    const form = document.getElementById('profileForm');
    const inputs = form.querySelectorAll('input');
    const saveButton = document.getElementById('saveButton');

    inputs.forEach(input => input.disabled = false);
    saveButton.style.display = 'inline-block';
    this.style.display = 'none'; 
});