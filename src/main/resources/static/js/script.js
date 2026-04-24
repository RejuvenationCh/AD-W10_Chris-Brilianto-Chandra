function openLightbox(element, isPortrait) {
    const modalElement = document.getElementById('lightboxModal');
    
    modalElement.classList.remove('modal-landscape', 'modal-portrait');
    modalElement.classList.add(isPortrait ? 'modal-portrait' : 'modal-landscape');

    document.getElementById('lightboxTitle').innerText = element.getAttribute('data-title');
    document.getElementById('lightboxSubtitle').innerText = element.getAttribute('data-subtitle');
    document.getElementById('lightboxDesc').innerText = element.getAttribute('data-desc');
    document.getElementById('lightboxImg').src = element.getAttribute('data-img');

    const modalInstance = bootstrap.Modal.getInstance(modalElement) || new bootstrap.Modal(modalElement);
    modalInstance.show();
}