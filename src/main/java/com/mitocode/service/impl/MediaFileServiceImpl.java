package com.mitocode.service.impl;

import com.mitocode.model.MediaFile;
import com.mitocode.repository.IGenericRepository;
import com.mitocode.repository.IMediaFileRepository;
import com.mitocode.service.IMediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaFileServiceImpl extends CRUDImpl<MediaFile, Integer> implements IMediaFileService {

    @Autowired
    private IMediaFileRepository repo;

    @Override
    protected IGenericRepository<MediaFile, Integer> getRepo() {
        return repo;
    }
}
